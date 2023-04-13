package app.web.orders.domain.order.order.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderClosed {
    private final long orderId;
}
