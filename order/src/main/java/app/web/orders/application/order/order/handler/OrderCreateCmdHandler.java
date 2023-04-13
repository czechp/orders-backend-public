package app.web.orders.application.order.order.handler;

import app.web.orders.domain.order.order.event.OrderCreated;
import app.web.orders.application.order.order.cmd.OrderCreateCmd;
import app.web.orders.domain.order.order.Order;
import app.web.orders.domain.order.order.OrderEventGenerator;
import app.web.orders.domain.order.order.OrderFactory;
import app.web.orders.domain.order.order.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class OrderCreateCmdHandler {
    private final OrderRepository orderRepository;

    public OrderCreated createOrder(OrderCreateCmd command) {
        Order order = OrderFactory.order(command.getName(), command.getDescription());
        Order persitedOrder = orderRepository.save(order);
        OrderEventGenerator orderEventGenerator = new OrderEventGenerator();
        return orderEventGenerator.createEvent(order);
    }
}
