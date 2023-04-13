package app.web.orders.application.order.order.handler;

import app.web.orders.application.order.order.cmd.OrderDeliverPositionCmd;
import app.web.orders.domain.order.order.Order;
import app.web.orders.domain.order.order.OrderRepository;
import app.web.orders.domain.order.order.event.OrderPositionDelivered;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class OrderDeliverPositionCmdHandler {
    private final OrderRepository orderRepository;

    public OrderPositionDelivered handle(OrderDeliverPositionCmd command){
        Order order = orderRepository.findByIdOrThrowException(command.getOrderId());
        return order.deliverPosition(command.getPositionId());
    }
}
