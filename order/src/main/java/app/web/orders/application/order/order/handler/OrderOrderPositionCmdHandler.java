package app.web.orders.application.order.order.handler;

import app.web.orders.application.order.order.cmd.OrderOrderPositionCmd;
import app.web.orders.domain.order.order.Order;
import app.web.orders.domain.order.order.OrderRepository;
import app.web.orders.domain.order.order.event.OrderPositionOrdered;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@AllArgsConstructor
@Service
@Secured({"ROLE_MANAGEMENT", "ROLE_ADMIN"})
public class OrderOrderPositionCmdHandler {
    private final OrderRepository orderRepository;
    public OrderPositionOrdered handle(OrderOrderPositionCmd command) {
        Order order = orderRepository.findByIdOrThrowException(command.getOrderId());
        return order.orderPosition(command.getPositionId());
    }
}
