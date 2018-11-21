package pl.mbanacho.corpo.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mbanacho.corpo.database.model.Order;

import java.util.List;

public interface OrderRepository  extends JpaRepository<Order,Integer> {
    List<Order> findTop20ByOrderByOrderDateDesc();
}
