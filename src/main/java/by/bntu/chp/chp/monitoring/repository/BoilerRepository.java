package by.bntu.chp.chp.monitoring.repository;

import by.bntu.chp.chp.monitoring.service.model.Boiler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoilerRepository extends JpaRepository<Boiler, Long> {

}
