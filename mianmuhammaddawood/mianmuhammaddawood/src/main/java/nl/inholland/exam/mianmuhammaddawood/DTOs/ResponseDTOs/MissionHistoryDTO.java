package nl.inholland.exam.mianmuhammaddawood.DTOs.ResponseDTOs;

import nl.inholland.exam.mianmuhammaddawood.Models.Enums.MissionStatus;
import nl.inholland.exam.mianmuhammaddawood.Models.Mission;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public record MissionHistoryDTO(long id,
                                String name,
                                LocalDate startDate,
                                LocalDate endDate,
                                MissionStatus status,
                                long duration,
                                String shipName) {
  public MissionHistoryDTO(Mission mission) {
    this(
        mission.getId(),
        mission.getName(),
        mission.getStartDate(),
        mission.getEndDate(),
        mission.getStatus(),
        mission.getEndDate() != null ? ChronoUnit.DAYS.between(mission.getStartDate(), mission.getEndDate()) : 0,
        mission.getShip().getName()
    );
  }
}
