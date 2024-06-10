package nl.inholland.exam.mianmuhammaddawood.Services;

import jakarta.transaction.Transactional;
import nl.inholland.exam.mianmuhammaddawood.Models.CrewMember;
import nl.inholland.exam.mianmuhammaddawood.Models.Ship;
import nl.inholland.exam.mianmuhammaddawood.Repositories.ShipRepository;
import org.springframework.stereotype.Service;
import nl.inholland.exam.mianmuhammaddawood.Repositories.CrewMemberRepository;

@Service
@Transactional
public class CrewMemberService {
  private final CrewMemberRepository crewMemberRepository;

  private final ShipRepository shipRepository;

  public CrewMemberService(CrewMemberRepository crewMemberRepository, ShipRepository shipRepository) {
    this.crewMemberRepository = crewMemberRepository;
    this.shipRepository = shipRepository;
  }

  public CrewMember createNewCrewMember(String name, String rank, long shipId) {
    Ship ship = shipRepository.findById(shipId).orElseThrow(() -> new RuntimeException("Ship not found"));
    if (ship.getCrewMembers().size() >= ship.getCrewCapacity()) {
      throw new IllegalStateException("Ship capacity exceeded");
    }
    CrewMember crewMember = new CrewMember();
    crewMember.setName(name);
    crewMember.setRank(rank);
    crewMember.setShip(ship);
    return crewMemberRepository.save(crewMember);
  }

}
