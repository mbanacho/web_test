package pl.mbanacho.cars.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mbanacho.cars.database.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
