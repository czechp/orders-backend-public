package app.web.orders.application.order.order.handler;

import app.web.orders.domain.order.order.event.OrderInfoUpdated;
import app.web.orders.application.order.order.cmd.OrderUpdateInfoCmd;
import app.web.orders.domain.order.order.Order;
import app.web.orders.domain.order.order.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class OrderUpdateInfoCmdHandler {
    private final OrderRepository orderRepository;

    public OrderInfoUpdated updateInfo(OrderUpdateInfoCmd command){
        Order orderToUpdate = orderRepository.findByIdOrThrowException(command.getOrderId());
        return orderToUpdate.updateInfo(command.getName(), command.getDescription());
    }
}
