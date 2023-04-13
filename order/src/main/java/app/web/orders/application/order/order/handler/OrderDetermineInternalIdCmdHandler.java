package app.web.orders.application.order.order.handler;

import app.web.orders.application.order.order.cmd.OrderDetermineInternalIdCmd;
import app.web.orders.domain.order.order.Order;
import app.web.orders.domain.order.order.OrderRepository;
import app.web.orders.domain.order.order.event.OrderInternalIdDetermined;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Secured({"ROLE_MANAGEMENT", "ROLE_ADMIN"})
@AllArgsConstructor
@Service
public class OrderDetermineInternalIdCmdHandler {
    private final OrderRepository orderRepository;
    public OrderInternalIdDetermined handle(OrderDetermineInternalIdCmd command) {
        Order order = orderRepository.findByIdOrThrowException(command.getOrderId());
        return order.determineInternalId(command.getInternalId());
    }
}
