package pl.mbanacho.cars.service;

import org.springframework.stereotype.Service;
import pl.mbanacho.cars.database.model.User;

@Service
public class UserService {

    public User getUser() {
        User user = new User();
        return user;
    }
}
