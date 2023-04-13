package app.web.orders.domain.order.order.event;

import app.web.orders.domain.order.order.PositionUnit;
import app.web.orders.domainDrivenDesign.superClass.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public
class OrderPositionAdded extends DomainEvent {

    private final long orderId;
    private final long elementId;
    private final int quantity;
    private final PositionUnit positionUnit;


    public OrderPositionAdded(long orderId, long elementId, int quantity, PositionUnit positionUnit) {
        super();
        this.orderId = orderId;
        this.elementId = elementId;
        this.quantity = quantity;
        this.positionUnit = positionUnit;
    }
}
