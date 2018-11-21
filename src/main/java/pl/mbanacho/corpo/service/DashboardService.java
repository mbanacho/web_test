package pl.mbanacho.corpo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mbanacho.corpo.database.dao.OrderRepository;
import pl.mbanacho.corpo.database.model.Order;

import java.util.List;

@Service
public class DashboardService {

    private OrderRepository orderRepository;

    @Autowired
    public DashboardService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getLastTwentySales() {
        return orderRepository.findTop20ByOrderByOrderDateDesc();
    }
}
