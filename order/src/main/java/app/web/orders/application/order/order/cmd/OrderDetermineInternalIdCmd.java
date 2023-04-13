package app.web.orders.application.order.order.cmd;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderDetermineInternalIdCmd {
    private long orderId;
    private String internalId;
}
