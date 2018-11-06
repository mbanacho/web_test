package pl.mbanacho.cars.database.model;

import javax.persistence.*;

@Entity
public class CarBrand implements WithId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(unique= true, nullable= false)
    private String name;

    @ManyToOne
    private Dictionary country;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dictionary getCountry() {
        return country;
    }

    public void setCountry(Dictionary country) {
        this.country = country;
    }
}