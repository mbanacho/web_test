package pl.mbanacho.corpo.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mbanacho.corpo.database.dao.EmployeeRepository;
import pl.mbanacho.corpo.database.model.Employee;
import pl.mbanacho.corpo.model.input.employee.NewEmployee;
import pl.mbanacho.corpo.model.input.employee.UpdateEmployee;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long carId) {
        return null;
    }

    public Long addNewEmployee(NewEmployee newEmployee) {
        return null;
    }

    public Employee findAndUpdateEmployee(UpdateEmployee updateEmployee) {
        return null;
    }
}