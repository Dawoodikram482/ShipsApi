package nl.inholland.exam.mianmuhammaddawood.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Ship {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;
  private String classType;
  private int crewCapacity;
  @OneToMany(mappedBy = "ship", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonManagedReference
  @ToString.Exclude
  List<CrewMember> crewMembers;
  @OneToMany(mappedBy = "ship", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonManagedReference
  @ToString.Exclude
  List<Mission> missions;
}
