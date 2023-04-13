package app.web.orders.application.order.order.handler;

import app.web.orders.application.order.order.cmd.OrderRemovePositionCmd;
import app.web.orders.domain.order.order.Order;
import app.web.orders.domain.order.order.OrderRepository;
import app.web.orders.domain.order.order.event.OrderPositionRemoved;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class OrderRemovePositionCmdHandler {
    private final OrderRepository orderRepository;

    public OrderPositionRemoved handle(OrderRemovePositionCmd command) {
        Order order = orderRepository.findByIdOrThrowException(command.getOrderId());
        return order.removePosition(command.getPositionId());
    }
}
