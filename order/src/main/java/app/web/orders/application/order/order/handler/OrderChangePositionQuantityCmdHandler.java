package app.web.orders.application.order.order.handler;

import app.web.orders.application.order.order.cmd.OrderChangePositionQuantityCmd;
import app.web.orders.application.order.order.service.OrderOwnerService;
import app.web.orders.domain.order.order.Order;
import app.web.orders.domain.order.order.OrderRepository;
import app.web.orders.domain.order.order.event.OrderPositionQuantityChanged;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class OrderChangePositionQuantityCmdHandler {
    private OrderRepository orderRepository;
    private OrderOwnerService orderOwnerService;

    public OrderPositionQuantityChanged handle(OrderChangePositionQuantityCmd command) {
        Order order = orderRepository.findByIdOrThrowException(command.getOrderId());
        orderOwnerService.currentUserIsOwnerOrException(order.orderSnap());
        return order.changePositionQuantity(command.getPositionId(), command.getNewQuantity());
    }
}
