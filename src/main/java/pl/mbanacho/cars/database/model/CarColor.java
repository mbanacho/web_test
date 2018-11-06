package pl.mbanacho.cars.database.model;

import pl.mbanacho.cars.database.model.defined.type.ColorVersion;

import javax.persistence.*;

@Entity
public class CarColor implements WithId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne
    private Dictionary name;

    @Enumerated(EnumType.STRING)
    private ColorVersion version;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dictionary getName() {
        return name;
    }

    public void setName(Dictionary name) {
        this.name = name;
    }

    public ColorVersion getVersion() {
        return version;
    }

    public void setVersion(ColorVersion version) {
        this.version = version;
    }
}
