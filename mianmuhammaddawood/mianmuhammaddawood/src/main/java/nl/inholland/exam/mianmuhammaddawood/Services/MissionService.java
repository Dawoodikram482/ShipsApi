package nl.inholland.exam.mianmuhammaddawood.Services;

import jakarta.transaction.Transactional;
import nl.inholland.exam.mianmuhammaddawood.Models.Enums.MissionStatus;
import nl.inholland.exam.mianmuhammaddawood.Models.Mission;
import nl.inholland.exam.mianmuhammaddawood.Models.Ship;
import nl.inholland.exam.mianmuhammaddawood.Repositories.MissionRepository;
import nl.inholland.exam.mianmuhammaddawood.Repositories.ShipRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
@Transactional
public class MissionService {
  private final MissionRepository missionRepository;
  private final ShipRepository shipRepository;
  public MissionService(MissionRepository missionRepository, ShipRepository shipRepository) {
    this.missionRepository = missionRepository;
    this.shipRepository = shipRepository;
  }

  public Mission createNewMission(String name, long shipId, LocalDate startDate, MissionStatus status){
    Ship ship = shipRepository.findById(shipId
    ).orElseThrow(() -> new IllegalArgumentException("Ship not found"));

    Mission mission = new Mission();
    mission.setName(name);
    mission.setShip(ship);
    mission.setStartDate(startDate);
    mission.setStatus(status);
    return missionRepository.save(mission);
  }

  public Optional<Mission> updateMission( long shipId,String name, Optional<LocalDate> endDate, MissionStatus status){

    return missionRepository.findById(shipId).map(mission -> {
      mission.setName(name);
      endDate.ifPresent(mission::setEndDate);
      mission.setStatus(status);
      return missionRepository.save(mission);
    });
  }

}

