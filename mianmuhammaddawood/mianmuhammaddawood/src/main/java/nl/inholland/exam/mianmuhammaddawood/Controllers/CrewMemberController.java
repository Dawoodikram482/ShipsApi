package nl.inholland.exam.mianmuhammaddawood.Controllers;

import nl.inholland.exam.mianmuhammaddawood.DTOs.RequestDTOs.CrewMemberRequest;
import nl.inholland.exam.mianmuhammaddawood.DTOs.ResponseDTOs.ApiResponse;
import nl.inholland.exam.mianmuhammaddawood.DTOs.ResponseDTOs.CrewMemberDTO;
import nl.inholland.exam.mianmuhammaddawood.Models.CrewMember;
import nl.inholland.exam.mianmuhammaddawood.Services.CrewMemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crew-members")
public class CrewMemberController {
  private final CrewMemberService crewMemberService;
  public CrewMemberController(CrewMemberService crewMemberService) {
    this.crewMemberService = crewMemberService;
  }
  @PostMapping
  public ResponseEntity<Object> createCrewMember(@RequestBody CrewMemberRequest crewMemberRequest) {
    CrewMember crewMember = crewMemberService.createNewCrewMember(crewMemberRequest.name(), crewMemberRequest.rank(), crewMemberRequest.shipId());
    return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>("Crew member created successfully", new CrewMemberDTO(crewMember)));
  }
}
