package pl.mbanacho.corpo.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mbanacho.corpo.database.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
