package by.bntu.chp.chp.monitoring.service.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "boilers")
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"steamMetrics", "turbine"})
@EqualsAndHashCode(exclude = {"steamMetrics", "turbine"})
public class Boiler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String registrationNumber;
    private Date nextInspectionDate;
    private Integer manufactureYear;
    private Date installationDate;
    private double maxPressure;
    private String producer;
    private String model;

    @OneToMany(mappedBy = "boiler")
    private List<BoilerSteamMetric> steamMetrics;

    @ManyToOne
    @JoinColumn(name = "turbine_id", nullable = false)
    private Turbine turbine;
}
