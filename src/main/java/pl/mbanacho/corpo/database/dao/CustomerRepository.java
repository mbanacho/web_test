package pl.mbanacho.corpo.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mbanacho.corpo.database.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
