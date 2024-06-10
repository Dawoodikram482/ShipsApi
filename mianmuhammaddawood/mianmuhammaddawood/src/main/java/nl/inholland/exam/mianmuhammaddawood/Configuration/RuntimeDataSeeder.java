package nl.inholland.exam.mianmuhammaddawood.Configuration;

import nl.inholland.exam.mianmuhammaddawood.Models.CrewMember;
import nl.inholland.exam.mianmuhammaddawood.Models.Mission;
import nl.inholland.exam.mianmuhammaddawood.Models.Ship;
import nl.inholland.exam.mianmuhammaddawood.Repositories.CrewMemberRepository;
import nl.inholland.exam.mianmuhammaddawood.Repositories.MissionRepository;
import nl.inholland.exam.mianmuhammaddawood.Repositories.ShipRepository;
import nl.inholland.exam.mianmuhammaddawood.Models.Enums.MissionStatus;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class RuntimeDataSeeder implements ApplicationRunner {
  private final ShipRepository shipRepository;
  private final MissionRepository missionRepository;
  private final CrewMemberRepository crewMemberRepository;
  public RuntimeDataSeeder(ShipRepository shipRepository, MissionRepository missionRepository, CrewMemberRepository crewMemberRepository) {
    this.shipRepository = shipRepository;
    this.missionRepository = missionRepository;
    this.crewMemberRepository = crewMemberRepository;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Ship enterprise = new Ship();
    enterprise.setName("Enterprise");
    enterprise.setClassType("Constitution");
    enterprise.setCrewCapacity(2);
    shipRepository.save(enterprise);

    Ship voyager = new Ship();
    voyager.setName("Voyager");
    voyager.setClassType("Intrepid");
    voyager.setCrewCapacity(4);
    shipRepository.save(voyager);

    CrewMember kirk = new CrewMember();
    kirk.setName("James T Kirk");
    kirk.setRank("Captain");
    kirk.setShip(enterprise);
    crewMemberRepository.save(kirk);

    CrewMember spock = new CrewMember();
    spock.setName("Mr. Spock");
    spock.setRank("Science Officer");
    spock.setShip(enterprise);
    crewMemberRepository.save(spock);

    CrewMember janeway = new CrewMember();
    janeway.setName("Kathryn Janeway");
    janeway.setRank("Captain");
    janeway.setShip(voyager);
    crewMemberRepository.save(janeway);

    CrewMember chakotay = new CrewMember();
    chakotay.setName("Chakotay");
    chakotay.setRank("First Officer");
    chakotay.setShip(voyager);
    crewMemberRepository.save(chakotay);

    Mission exploreMission = new Mission();
    exploreMission.setName("Explore the universe");
    exploreMission.setStartDate(LocalDate.of(2024, 6, 24));
    exploreMission.setStatus(MissionStatus.CURRENT);
    exploreMission.setShip(enterprise);
    missionRepository.save(exploreMission);

    Mission nebulaMission = new Mission();
    nebulaMission.setName("Scan a nebula");
    nebulaMission.setStartDate(LocalDate.of(2024, 6, 24));
    nebulaMission.setEndDate(LocalDate.of(2024, 6, 25));
    nebulaMission.setStatus(MissionStatus.CANCELLED);
    nebulaMission.setShip(enterprise);
    missionRepository.save(nebulaMission);

    Mission deltaQuadrantMission = new Mission();
    deltaQuadrantMission.setName("Explore the Delta Quadrant");
    deltaQuadrantMission.setStartDate(LocalDate.of(2024, 6, 24));
    deltaQuadrantMission.setStatus(MissionStatus.CURRENT);
    deltaQuadrantMission.setShip(voyager);
    missionRepository.save(deltaQuadrantMission);
  }
}
