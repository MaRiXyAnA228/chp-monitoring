package by.bntu.chp.chp.monitoring.repository;

import by.bntu.chp.chp.monitoring.service.model.BoilerSteamMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BoilerSteamMetricRepository extends JpaRepository<BoilerSteamMetric, Long> {
    List<BoilerSteamMetric> findByTimestampBetweenOrderByTimestampAsc(LocalDate startDate, LocalDate endDate);

    List<BoilerSteamMetric> findByBoilerId(Long id);
}
