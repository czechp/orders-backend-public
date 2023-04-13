package app.web.orders.domain.order.order.event;

import app.web.orders.domainDrivenDesign.annotation.DomainEvent;
import lombok.AllArgsConstructor;

@DomainEvent
@AllArgsConstructor
public class OrderCreated {
    private final long id;
    private final String name;
    private final String description;
}
