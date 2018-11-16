package pl.mbanacho.corpo.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mbanacho.corpo.database.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
    User findUserByEmail(String email);
}
