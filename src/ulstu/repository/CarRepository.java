package ru.ulstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ulstu.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByName(String name);
}