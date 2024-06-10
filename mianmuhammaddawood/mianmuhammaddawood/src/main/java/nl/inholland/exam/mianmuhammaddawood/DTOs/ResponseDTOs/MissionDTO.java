package nl.inholland.exam.mianmuhammaddawood.DTOs.ResponseDTOs;

import nl.inholland.exam.mianmuhammaddawood.Models.Enums.MissionStatus;
import nl.inholland.exam.mianmuhammaddawood.Models.Mission;

import java.time.temporal.ChronoUnit;

public record MissionDTO(long id,
                         String name,
                         String startDate,
                         String endDate,
                         MissionStatus status,
                         long duration,
                         String shipName) {
  public MissionDTO(Mission mission) {
    this(
        mission.getId(),
        mission.getName(),
        mission.getStartDate().toString(),
        mission.getEndDate() != null ? mission.getEndDate().toString() : null,
        mission.getStatus(),
        mission.getEndDate() != null ? ChronoUnit.DAYS.between(mission.getStartDate(), mission.getEndDate()) : 0,
        mission.getShip().getName()
    );
  }
}
