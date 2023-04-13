package app.web.orders.application.order.order.handler;

import app.web.orders.application.order.order.cmd.OrderRemoveCmd;
import app.web.orders.application.order.order.service.OrderOwnerService;
import app.web.orders.domain.order.order.Order;
import app.web.orders.domain.order.order.OrderRepository;
import app.web.orders.domain.order.order.event.OrderRemoved;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class OrderRemoveCmdHandler {
    private final OrderRepository orderRepository;
    private final OrderOwnerService orderOwnerService;

    public OrderRemoved handle(OrderRemoveCmd command) {
        Order orderToRemove = orderRepository.findByIdOrThrowException(command.getOrderId());
        orderOwnerService.currentUserIsOwnerOrException(orderToRemove.orderSnap());
        orderRepository.removeById(command.getOrderId());
        return new OrderRemoved(command.getOrderId());
    }
}
