package nl.inholland.exam.mianmuhammaddawood.DTOs.ResponseDTOs;

import nl.inholland.exam.mianmuhammaddawood.Models.Ship;

import java.util.List;

public record ShipDTO(long id, String name, String classType, int crewCapacity, List<CrewMemberDTO> crewMembers, List<MissionDTO> missions) {
  public ShipDTO(Ship ship) {
    this(
        ship.getId(),
        ship.getName(),
        ship.getClassType(),
        ship.getCrewCapacity(),
        ship.getCrewMembers().stream().map(CrewMemberDTO::new).toList(),
        ship.getMissions().stream().map(MissionDTO::new).toList()
    );
  }
}
