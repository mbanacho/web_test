package pl.mbanacho.cars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mbanacho.cars.database.model.Car;
import pl.mbanacho.cars.service.CarService;

import java.util.List;

@RestController
@RequestMapping(value="/car")
public class CarController {

    @Autowired
    CarService service;

    @GetMapping
    public ResponseEntity<List<Car>> getCars(){
        try{
            List<Car> cars = service.getAllCars();
            return ResponseEntity.ok(cars);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{carId}")
    public ResponseEntity<Car> getCarWithId(@PathVariable("carId")Long carId){
        try{
            Car car = service.getCarById(carId);
            return ResponseEntity.ok(car);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Long> addCar(@RequestBody Car car){
        try{
            Long carId = service.addNewCar(car);
            return ResponseEntity.ok(carId);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity<Car> updateCarById(@RequestBody Car car){
        try{
            Car updatedCar = service.updateCar(car);
            return ResponseEntity.ok(updatedCar);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}