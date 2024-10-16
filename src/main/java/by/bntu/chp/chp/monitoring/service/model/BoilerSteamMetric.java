package by.bntu.chp.chp.monitoring.service.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "boiler_steam_metrics")
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"boiler"})
@EqualsAndHashCode(exclude = {"boiler"})
public class BoilerSteamMetric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate timestamp;
    private Double steamVolume;

    @ManyToOne
    @JoinColumn(name="boiler_id", nullable=false)
    private Boiler boiler;
}
