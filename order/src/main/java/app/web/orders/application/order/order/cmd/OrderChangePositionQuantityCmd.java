package app.web.orders.application.order.order.cmd;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderChangePositionQuantityCmd {
    private long orderId;
    private long positionId;
    private int newQuantity;
}
