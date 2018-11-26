package pl.mbanacho.corpo.service.employee;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import pl.mbanacho.corpo.database.dao.EmployeeRepository;
import pl.mbanacho.corpo.database.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class EmployeeServiceTest {

    @InjectMocks
    EmployeeService employeeService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllEmployee() {
        // given

        // when

        // then
    }

    @Test
    public void getEmployeeById() {
       System.out.print(Optional.of(new Integer(100)).flatMap(s->Optional.ofNullable(s)).isPresent());
        System.out.print("dddddddddddddd");
    }

    @Test
    public void addNewEmployee() {
    }

    @Test
    public void findAndUpdateEmployee() {
    }
}