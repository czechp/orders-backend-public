package app.web.orders.application.order.order.cmd;

import app.web.orders.domain.order.order.OrderData;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Data
public class OrderUpdateInfoCmd {
    private long orderId;
    @Length(min = OrderData.OrderInfo.NAME_MIN_LENGTH, max = OrderData.OrderInfo.NAME_MAX_LENGTH)
    private String name;
    private String description;
}
