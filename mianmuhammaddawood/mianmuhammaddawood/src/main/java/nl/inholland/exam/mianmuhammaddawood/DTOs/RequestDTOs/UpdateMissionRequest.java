package nl.inholland.exam.mianmuhammaddawood.DTOs.RequestDTOs;

import nl.inholland.exam.mianmuhammaddawood.Models.Enums.MissionStatus;

import java.util.Optional;

public record UpdateMissionRequest(String name,
    Optional<String>endDate,
     MissionStatus status) {
}
