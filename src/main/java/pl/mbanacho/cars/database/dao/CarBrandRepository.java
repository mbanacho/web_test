package pl.mbanacho.cars.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mbanacho.cars.database.model.CarBrand;

public interface CarBrandRepository extends JpaRepository<CarBrand,Long> {
    CarBrand findByName(String brandName);
}
