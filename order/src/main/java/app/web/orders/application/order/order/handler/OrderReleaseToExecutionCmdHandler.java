package app.web.orders.application.order.order.handler;

import app.web.orders.application.order.order.cmd.OrderReleaseToExecutionCmd;
import app.web.orders.application.order.order.service.OrderEmailService;
import app.web.orders.application.order.order.service.OrderOwnerService;
import app.web.orders.domain.order.order.Order;
import app.web.orders.domain.order.order.OrderRepository;
import app.web.orders.domain.order.order.event.OrderReleasedToExecution;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class OrderReleaseToExecutionCmdHandler {
    private final OrderRepository orderRepository;
    private final OrderOwnerService orderOwnerService;
    private final OrderEmailService orderEmailService;

    public OrderReleasedToExecution handle(OrderReleaseToExecutionCmd command) {

        Order order = orderRepository.findByIdOrThrowException(command.getOrderId());
        orderOwnerService.currentUserIsOwnerOrException(order.orderSnap());
        orderEmailService.orderReleasedToExecution(order.orderSnap());
        return order.releaseToExecution();
    }

    ;
}
