package by.bntu.chp.chp.monitoring.repository;

import by.bntu.chp.chp.monitoring.service.model.TurbinePressureMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TurbinePressureMetricRepository extends JpaRepository<TurbinePressureMetric, Long> {
    List<TurbinePressureMetric> findByTimestampBetweenOrderByTimestampAsc(LocalDateTime startDate, LocalDateTime endDate);

    List<TurbinePressureMetric> findByTurbineId(Long id);
}
