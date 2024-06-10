package nl.inholland.exam.mianmuhammaddawood.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import nl.inholland.exam.mianmuhammaddawood.Models.Enums.MissionStatus;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Mission {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;

  private LocalDate startDate;

  private LocalDate endDate;

  @ManyToOne
  @JsonBackReference
  private Ship ship;

  @Enumerated(EnumType.STRING)
  private MissionStatus status;
}
