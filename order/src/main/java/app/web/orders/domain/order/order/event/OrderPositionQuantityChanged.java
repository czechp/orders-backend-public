package app.web.orders.domain.order.order.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderPositionQuantityChanged {
    private long orderId;
    private long positionId;
    private int newQuantity;
}
