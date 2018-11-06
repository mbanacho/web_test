package pl.mbanacho.cars.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mbanacho.cars.database.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
