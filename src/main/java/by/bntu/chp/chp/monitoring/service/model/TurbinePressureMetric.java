package by.bntu.chp.chp.monitoring.service.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "turbine_pressure_metrics")
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"turbine"})
@EqualsAndHashCode(exclude = {"turbine"})
public class TurbinePressureMetric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double pressure;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name="turbine_id", nullable=false)
    private Turbine turbine;
}
