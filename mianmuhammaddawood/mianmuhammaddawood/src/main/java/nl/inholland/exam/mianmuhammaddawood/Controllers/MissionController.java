package nl.inholland.exam.mianmuhammaddawood.Controllers;

import nl.inholland.exam.mianmuhammaddawood.DTOs.RequestDTOs.MissionRequest;
import nl.inholland.exam.mianmuhammaddawood.DTOs.RequestDTOs.UpdateMissionRequest;
import nl.inholland.exam.mianmuhammaddawood.DTOs.ResponseDTOs.ApiResponse;
import nl.inholland.exam.mianmuhammaddawood.DTOs.ResponseDTOs.MissionDTO;
import nl.inholland.exam.mianmuhammaddawood.Models.Mission;
import nl.inholland.exam.mianmuhammaddawood.Services.MissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/missions")
public class MissionController {
  private final MissionService missionService;
  public MissionController(MissionService missionService) {
    this.missionService = missionService;
  }
  @PostMapping
  public ResponseEntity<Object> createMission(@RequestBody MissionRequest missionRequest) {
    Mission mission = missionService.createNewMission(missionRequest.name(), missionRequest.shipId(), LocalDate.parse(missionRequest.startDate()), missionRequest.status());
    return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>("Mission created successfully", mission));
  }
  @PutMapping("/{id}")
  public ResponseEntity<Object> updateMission(@PathVariable long id, @RequestBody UpdateMissionRequest missionUpdateRequest) {
    Optional<Mission> updatedMission = missionService.updateMission(id, missionUpdateRequest.name(), missionUpdateRequest.endDate().map(LocalDate::parse), missionUpdateRequest.status());
    if (updatedMission.isPresent()) {
      return ResponseEntity.ok(new ApiResponse<>("Mission updated successfully", new MissionDTO(updatedMission.get())));
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>("Mission not found", null));
    }
  }
}
