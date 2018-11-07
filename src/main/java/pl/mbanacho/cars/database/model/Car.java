package pl.mbanacho.cars.database.model;

import javax.persistence.*;

@Entity
public class Car implements WithId {

    public Car() {
    }

    public Car(CarBrand carBrand, CarModel carModel, CarColor carColor, String version, Integer productionYear) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carColor = carColor;
        this.version = version;
        this.productionYear = productionYear;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne
    private CarBrand carBrand;

    @ManyToOne
    private CarModel carModel;

    @ManyToOne
    private CarColor carColor;

    private String version;

    private Integer productionYear;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public CarColor getCarColor() {
        return carColor;
    }

    public void setCarColor(CarColor carColor) {
        this.carColor = carColor;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }
}