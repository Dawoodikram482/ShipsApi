package nl.inholland.exam.mianmuhammaddawood.Services;

import jakarta.transaction.Transactional;
import nl.inholland.exam.mianmuhammaddawood.Models.Ship;
import nl.inholland.exam.mianmuhammaddawood.Repositories.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ShipService {

  private final ShipRepository shipRepository;

  public ShipService(ShipRepository shipRepository) {
    this.shipRepository = shipRepository;
  }

  public List<Ship> getAllShips() {
    return shipRepository.findAll();
  }

  public Ship createNewShip(String name, String classType, int crewCapacity){
    Ship ship = new Ship();
    ship.setName(name);
    ship.setClassType(classType);
    ship.setCrewCapacity(crewCapacity);
    return shipRepository.save(ship);
  }
  public Ship getShipById(long id){
    return shipRepository.findById(id).orElseThrow();
  }
}
