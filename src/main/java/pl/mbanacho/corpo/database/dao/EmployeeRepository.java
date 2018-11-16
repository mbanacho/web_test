package pl.mbanacho.corpo.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mbanacho.corpo.database.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
