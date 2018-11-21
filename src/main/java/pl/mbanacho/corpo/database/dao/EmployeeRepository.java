package pl.mbanacho.corpo.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mbanacho.corpo.database.model.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    List<Employee> findByJobTitleIn(String[] jobTitles);
}
