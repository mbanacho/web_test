package pl.mbanacho.corpo.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mbanacho.corpo.database.model.Productline;

public interface ProductlineRepository  extends JpaRepository<Productline,String> {
}
