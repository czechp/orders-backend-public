package app.web.orders.application.order.order.cmd;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OrderReleaseToExecutionCmd {
    private long orderId;
}
