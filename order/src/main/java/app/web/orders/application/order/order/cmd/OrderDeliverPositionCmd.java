package app.web.orders.application.order.order.cmd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Data
public class OrderDeliverPositionCmd {
    private long orderId;
    private long positionId;
}
