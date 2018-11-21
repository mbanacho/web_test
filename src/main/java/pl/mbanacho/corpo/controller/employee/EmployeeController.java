package pl.mbanacho.corpo.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.mbanacho.corpo.database.model.Employee;
import pl.mbanacho.corpo.model.input.employee.NewEmployee;
import pl.mbanacho.corpo.model.input.employee.UpdateEmployee;
import pl.mbanacho.corpo.service.employee.EmployeeService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping(value="/employee")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping
    public ModelAndView getEmployees(Model model){
        ModelAndView mav = new ModelAndView("employee/employee");
        try{
            List<Employee> employees = service.getAllEmployee();
            mav.addObject("employees",employees);
            mav.setStatus(HttpStatus.OK);
            return mav;
        }catch(Exception e){
            mav.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
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

    @GetMapping("/add")
    public ModelAndView addEmployees(Model model){
        ModelAndView mav = new ModelAndView("employee/add_new_employee");
        try{
            mav.addObject("newEmployee",new NewEmployee());
            mav.setStatus(HttpStatus.OK);
            return mav;
        }catch(Exception e){
            mav.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return mav;
        }
    }

    @PostMapping
    public ModelAndView addEmployee( @Valid NewEmployee newEmployee, BindingResult result){
        ModelAndView mav = new ModelAndView("employee/employee");
        if(result.hasErrors()) {
            mav.setViewName("employee/add_new_employee");

            //Podejscie I
            String field = new String("startDate");
            FieldError fieldError = result.getFieldError(field);
            if(fieldError!=null){
                mav.addObject("error_"+field,"wrong "+fieldError.getField());
            }

            //Podejscie II
            mav.addObject("error_pesel","wrong "+result.getFieldError("pesel").getField());
            return mav;

            //...??? znalezc lepsza walidacje

        }
        try{
            Integer employeeId = service.addNewEmployee(newEmployee);
            mav.addObject("employeeId",employeeId);
            List<Employee> employees = service.getAllEmployee();
            mav.addObject("employees",employees);
            mav.setStatus(HttpStatus.OK);
            return mav;
        }catch(Exception e){
            mav.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            mav.addObject("error","add employee fail");
            return mav;
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


    @ModelAttribute("officeCodes")
    public Map<String,String> populatePlanets() {
        return service.getAllOfficeCodes();
    }

    @ModelAttribute("jobTitles")
    public List<String> jobTitles() {
        return Arrays.asList(new String[] {
                "President","VP Sales","VP Marketing","Sales Manager (APAC)","Sale Manager (EMEA)","Sales Manager (NA)","Sales Rep"
        });
    }

    @ModelAttribute("employeesReportTo")
    public Map<Integer,String> employeesReportTo() {
        return service.getAllEmployeeAvailableToBeReporter();
    }
}