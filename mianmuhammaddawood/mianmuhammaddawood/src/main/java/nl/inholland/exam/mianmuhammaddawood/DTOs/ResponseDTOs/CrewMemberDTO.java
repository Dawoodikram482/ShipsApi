package nl.inholland.exam.mianmuhammaddawood.DTOs.ResponseDTOs;

import nl.inholland.exam.mianmuhammaddawood.Models.CrewMember;

public record CrewMemberDTO(long id,
                            String name,
                            String rank) {
  public CrewMemberDTO(CrewMember crewMember) {
    this(
        crewMember.getId(),
        crewMember.getName(),
        crewMember.getRank()
    );
  }
}
