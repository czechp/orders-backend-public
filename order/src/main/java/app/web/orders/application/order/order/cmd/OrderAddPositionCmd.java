package app.web.orders.application.order.order.cmd;

import app.web.orders.domain.order.order.PositionUnit;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OrderAddPositionCmd {
    private long orderId;
    private long elementId;
    private int quantity;
    private PositionUnit positionUnit;
}
