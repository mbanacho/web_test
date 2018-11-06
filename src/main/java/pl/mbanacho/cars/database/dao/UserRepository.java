package pl.mbanacho.cars.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mbanacho.cars.database.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String name);
}
