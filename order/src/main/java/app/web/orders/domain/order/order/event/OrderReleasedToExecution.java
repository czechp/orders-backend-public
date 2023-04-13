package app.web.orders.domain.order.order.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderReleasedToExecution {
    private long orderId;
}
