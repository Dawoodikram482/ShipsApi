package nl.inholland.exam.mianmuhammaddawood.DTOs.RequestDTOs;

import nl.inholland.exam.mianmuhammaddawood.Models.Enums.MissionStatus;

public record MissionRequest(String name,
                             long shipId,
                             String startDate, MissionStatus status) {
}
