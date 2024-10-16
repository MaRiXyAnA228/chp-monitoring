package by.bntu.chp.chp.monitoring.service.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "turbines")
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"pressureMetrics", "boilers"})
@EqualsAndHashCode(exclude = {"pressureMetrics", "boilers"})
public class Turbine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String registrationNumber;
    private Date nextInspectionDate;
    private Date installationDate;

    @OneToMany(mappedBy = "turbine")
    private List<TurbinePressureMetric> pressureMetrics;

    @OneToMany(mappedBy = "turbine", fetch = FetchType.EAGER)
    private List<Boiler> boilers;

}
