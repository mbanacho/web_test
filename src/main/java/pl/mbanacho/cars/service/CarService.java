package pl.mbanacho.cars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mbanacho.cars.database.dao.CarRepository;
import pl.mbanacho.cars.database.model.Car;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public List<Car> getAllCars() {
        //TODO
        return null;
    }

    public Car getCarById(Long carId) {
        //TODO
        return null;
    }

    public Long addNewCar(Car car) {

        return null;
    }

    public Car updateCar(Car car) {
        //TODO
        return null;
    }
}