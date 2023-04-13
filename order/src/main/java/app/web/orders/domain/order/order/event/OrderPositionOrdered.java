package app.web.orders.domain.order.order.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderPositionOrdered {
    private final long orderId;
    private final long positionId;
}
