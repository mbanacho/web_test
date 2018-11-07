package pl.mbanacho.cars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mbanacho.cars.database.dao.CarBrandRepository;
import pl.mbanacho.cars.database.dao.CarRepository;
import pl.mbanacho.cars.database.model.Car;
import pl.mbanacho.cars.database.model.CarBrand;
import pl.mbanacho.cars.model.json.car.NewCar;
import pl.mbanacho.cars.model.json.car.UpdateCar;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarBrandRepository carBrandRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(Long carId) {
        return carRepository.findById(carId);
    }

    public Long addNewCar(NewCar newCar) {
        Car car = new Car();
        car.setCarBrand(getCarBrandByName(newCar.getCarBrand()));
        Long newCarId = carRepository.save(car).getId();
        return newCarId;
    }

    public Car updateCar(UpdateCar updateCar) {
        //TODO
        return null;
    }

    private CarBrand getCarBrandByName(String brandName){
        return carBrandRepository.findByName(brandName);
    }


}