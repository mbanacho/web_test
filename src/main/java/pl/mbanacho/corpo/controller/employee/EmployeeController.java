package pl.mbanacho.corpo.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.mbanacho.corpo.database.model.Employee;
import pl.mbanacho.corpo.model.input.employee.NewEmployee;
import pl.mbanacho.corpo.model.input.employee.UpdateEmployee;
import pl.mbanacho.corpo.service.employee.EmployeeService;
import pl.mbanacho.corpo.service.queue.RabbitMqProducer;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value="/employee")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @Autowired
    RabbitMqProducer rabbitMqProducer;

    @GetMapping
    public ModelAndView getEmployees(Model model){
        ModelAndView mav = new ModelAndView("employee/employee");
        try{
            List<Employee> employees = service.getAllEmployee();
            mav.addObject("employees",employees);
            mav.setStatus(HttpStatus.OK);
            return mav;
        }catch(Exception e){
            mav.setStatus(HttpStatus.BAD_REQUEST);
            mav.setViewName("error");
            return mav;
        }
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeWithId(@PathVariable("employeeId")Long employeeId){
        try{
            Optional<Employee> employee = service.getEmployeeById(employeeId);
            if(employee.isPresent()){
                return ResponseEntity.ok(employee.get());
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Long> addEmployee(@RequestBody NewEmployee newEmployee){
        try{
            Long employeeId = service.addNewEmployee(newEmployee);
            return ResponseEntity.ok(employeeId);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployeeById(@RequestBody UpdateEmployee updateEmployee){
        try{
            Employee updatedEmployee = service.findAndUpdateEmployee(updateEmployee);
            return ResponseEntity.ok(updatedEmployee);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}