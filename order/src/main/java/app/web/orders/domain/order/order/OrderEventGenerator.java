package app.web.orders.domain.order.order;

import app.web.orders.domainDrivenDesign.annotation.DomainService;
import app.web.orders.domain.order.order.event.OrderCreated;

@DomainService
public class OrderEventGenerator {
    public OrderCreated createEvent(Order order) {
        OrderBasicImpl orderBasic = (OrderBasicImpl) order;
        return new OrderCreated(orderBasic.getId(),
                orderBasic.getOrderInfo().getName(),
                orderBasic.getOrderInfo().getDescription());
    }
}
