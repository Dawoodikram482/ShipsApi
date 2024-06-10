package nl.inholland.exam.mianmuhammaddawood.Repositories;

import nl.inholland.exam.mianmuhammaddawood.Models.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long>{
}
