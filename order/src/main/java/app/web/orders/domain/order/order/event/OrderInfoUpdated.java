package app.web.orders.domain.order.order.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderInfoUpdated {
    private final long orderId;
    private final String name;
    private final String description;
}
