package app.web.orders.application.order.order.handler;

import app.web.orders.application.order.order.cmd.OrderAddPositionCmd;
import app.web.orders.application.order.order.service.OrderOwnerService;
import app.web.orders.domain.element.element.ElementRepository;
import app.web.orders.domain.order.order.Order;
import app.web.orders.domain.order.order.OrderRepository;
import app.web.orders.domain.order.order.event.OrderPositionAdded;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@AllArgsConstructor
public class OrderAddPositionCmdHandler {
    private final OrderRepository orderRepository;
    private final ElementRepository elementRepository;
    private final OrderOwnerService orderOwnerService;

    public OrderPositionAdded addPosition(OrderAddPositionCmd command) {
        Order order = orderRepository.findByIdOrThrowException(command.getOrderId());
        orderOwnerService.currentUserIsOwnerOrException(order.orderSnap());
        elementRepository.findByIdOrThrowException(command.getElementId());
        return order.addPosition(command.getElementId(), command.getQuantity(), command.getPositionUnit());
    }
}
