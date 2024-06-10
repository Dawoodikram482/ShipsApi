package nl.inholland.exam.mianmuhammaddawood.Repositories;

import nl.inholland.exam.mianmuhammaddawood.Models.CrewMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewMemberRepository extends JpaRepository<CrewMember, Long>{
}
