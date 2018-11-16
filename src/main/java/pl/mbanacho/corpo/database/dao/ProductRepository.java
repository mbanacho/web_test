package pl.mbanacho.corpo.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mbanacho.corpo.database.model.Product;

public interface ProductRepository  extends JpaRepository<Product,String> {
}
