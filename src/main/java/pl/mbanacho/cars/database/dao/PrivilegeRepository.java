package pl.mbanacho.cars.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mbanacho.cars.database.model.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege,Long> {
    Privilege findByName(String name);
}
