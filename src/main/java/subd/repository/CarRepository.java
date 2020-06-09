package subd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import subd.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    @Query(" select new  subd.repository.CarWithCount (model, count(*))" +
            "from car order by model;")
    public List<Car> getCar();
}