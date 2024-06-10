package nl.inholland.exam.mianmuhammaddawood.Controllers;

import nl.inholland.exam.mianmuhammaddawood.DTOs.RequestDTOs.ShipRequest;
import nl.inholland.exam.mianmuhammaddawood.DTOs.ResponseDTOs.ApiResponse;
import nl.inholland.exam.mianmuhammaddawood.DTOs.ResponseDTOs.MissionDTO;
import nl.inholland.exam.mianmuhammaddawood.DTOs.ResponseDTOs.MissionHistoryDTO;
import nl.inholland.exam.mianmuhammaddawood.DTOs.ResponseDTOs.ShipDTO;
import nl.inholland.exam.mianmuhammaddawood.Models.Ship;
import nl.inholland.exam.mianmuhammaddawood.Services.MissionService;
import nl.inholland.exam.mianmuhammaddawood.Services.ShipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ships")
public class ShipController {
  private final ShipService shipService;
  private final MissionService missionService;

  public ShipController(ShipService shipService, MissionService missionService) {
    this.shipService = shipService;
    this.missionService = missionService;
  }

  @GetMapping
  public ResponseEntity<Object> getAllShips() {
    List<ShipDTO> ships = shipService.getAllShips().stream().map(ShipDTO::new).collect(Collectors.toList());
    return ResponseEntity.ok(new ApiResponse<>("Ships fetched successfully", ships));
  }
  @PostMapping
  public ResponseEntity<Object> createShip(@RequestBody ShipRequest shipRequest) {
    Ship ship = shipService.createNewShip(shipRequest.name(), shipRequest.classType(), shipRequest.crewCapacity());
    return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>("Ship created successfully",ship));
  }
  @GetMapping("/{id}/history")
  public ResponseEntity<Object> getShipHistory(@PathVariable long id) {
    Ship ship = shipService.getShipById(id);
    List<MissionHistoryDTO> history = ship.getMissions().stream()
        .map(MissionHistoryDTO::new)
        .collect(Collectors.toList());
    return ResponseEntity.ok(new ApiResponse<>("Ship history fetched successfully", history));
  }

}
