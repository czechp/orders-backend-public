package app.web.orders.application.order.order.cmd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderOrderPositionCmd {
    private long orderId;
    private long positionId;
}
