package pl.mbanacho.corpo.service.employee;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mbanacho.corpo.database.dao.EmployeeRepository;
import pl.mbanacho.corpo.database.dao.OfficeRepository;
import pl.mbanacho.corpo.database.model.Employee;
import pl.mbanacho.corpo.database.model.Office;
import pl.mbanacho.corpo.model.input.employee.NewEmployee;
import pl.mbanacho.corpo.model.input.employee.UpdateEmployee;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    Logger LOG = LoggerFactory.getLogger(EmployeeService.class);

    private EmployeeRepository employeeRepository;
    private OfficeRepository officeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, OfficeRepository officeRepository) {
        this.employeeRepository = employeeRepository;
        this.officeRepository = officeRepository;
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long carId) {
        return null;
    }

    public Integer addNewEmployee(NewEmployee sourceEmployee) {
        Employee newEmployee = new Employee();
        newEmployee.setOfficeCode(findOfficeWithId(sourceEmployee.getOfficeCode()));
        newEmployee.setReportsTo(findEmployeeWithId(sourceEmployee.getReportsTo()));
        newEmployee.setExtension(sourceEmployee.getExtension());
        newEmployee.setEmail(sourceEmployee.getEmail());
        newEmployee.setFirstName(sourceEmployee.getFirstName());
        newEmployee.setLastName(sourceEmployee.getLastName());
        newEmployee.setJobTitle(sourceEmployee.getJobTitle());

        Employee employee = employeeRepository.save(newEmployee);
        LOG.debug("Add new Employee with identifier " + employee.getEmployeeNumber());
        return employee.getEmployeeNumber();
    }

    private Employee findEmployeeWithId(Integer employeeId) {
        LOG.debug("Finding Employee with identifier "+employeeId);
        return employeeRepository.findById(employeeId).orElseThrow(IllegalArgumentException::new);
    }

    private Office findOfficeWithId(String officeCode) {
        LOG.debug("Finding office with identifier "+officeCode);
        return officeRepository.findById(officeCode).orElseThrow(IllegalArgumentException::new);
    }

    public Employee findAndUpdateEmployee(UpdateEmployee updateEmployee) {
        return null;
    }

    public Map<Integer,String> getAllEmployeeAvailableToBeReporter() {
        Function<Employee,String> getEmployeeName = employee -> employee.getFirstName()+employee.getLastName();
        Function<Employee,Integer> getEmployeeId = employee -> employee.getEmployeeNumber();

        Map<Integer,String> employeesReportsTo = employeeRepository
                .findByJobTitleIn(new String[]{"President","VP Sales","VP Marketing","Sales Manager (APAC)","Sale Manager (EMEA)","Sales Manager (NA)"})
                .stream().collect(Collectors.toMap(getEmployeeId,getEmployeeName));

        return employeesReportsTo;
    }

    public Map<String,String> getAllOfficeCodes() {
        Function<Office,String> getOfficeCode = office -> office.getOfficeCode();
        Function<Office,String> getOfficeAddress = office -> office.getAddressLine1()+""+office.getAddressLine2();
        Map<String,String> officeCodes = officeRepository.findAll()
                .stream().collect(Collectors.toMap(getOfficeCode,getOfficeAddress));
        return officeCodes;
    }
}