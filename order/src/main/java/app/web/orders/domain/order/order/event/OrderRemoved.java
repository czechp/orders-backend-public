package app.web.orders.domain.order.order.event;

import app.web.orders.domainDrivenDesign.annotation.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;

@DomainEvent
@AllArgsConstructor
@Getter
public
class OrderRemoved {
    private final long orderId;
}
