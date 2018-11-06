package pl.mbanacho.cars.controller;

import pl.mbanacho.cars.database.model.User;
import pl.mbanacho.cars.service.UserService;
import pl.mbanacho.cars.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IndexController {

    private SimpleService service;
    private UserService userService;

    @Autowired
    public IndexController(SimpleService service, UserService userService) {
        this.service = service;
        this.userService=userService;
    }

    @GetMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getIndexPage(){
        service.aasfdg(100);
        return service.getIndexPage();
    }

    @PostMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> addUser(@PathVariable("id") Integer id){
        try {
            return ResponseEntity.ok(userService.getUser());
        }catch (NullPointerException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}