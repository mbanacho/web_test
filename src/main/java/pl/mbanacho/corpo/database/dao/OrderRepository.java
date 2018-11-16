package pl.mbanacho.corpo.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mbanacho.corpo.database.model.Order;

public interface OrderRepository  extends JpaRepository<Order,Integer> {
}
