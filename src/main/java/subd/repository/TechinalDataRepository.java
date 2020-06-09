package subd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import subd.model.TechnicalData;

@Repository
public interface TechnicalDataRepository extends JpaRepository<TechnicalData, Integer> {
}