package app.web.orders.application.order.order.handler;

import app.web.orders.application.order.order.cmd.OrderCloseCmd;
import app.web.orders.domain.order.order.Order;
import app.web.orders.domain.order.order.OrderRepository;
import app.web.orders.domain.order.order.event.OrderClosed;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
@Secured({"ROLE_MANAGEMENT", "ROLE_ADMIN"})
public class OrderCloseCmdHandler {
    private final OrderRepository orderRepository;

    public OrderClosed handle(OrderCloseCmd command) {
        Order orderToClose = orderRepository.findByIdOrThrowException(command.getOrderId());
        return orderToClose.close();
    }
}
