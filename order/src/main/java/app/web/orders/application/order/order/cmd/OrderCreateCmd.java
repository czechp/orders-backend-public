package app.web.orders.application.order.order.cmd;

import app.web.orders.domain.order.order.OrderData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Getter
@Setter
public class OrderCreateCmd {
    @Getter
    @Length(min = OrderData.OrderInfo.NAME_MIN_LENGTH,
    max = OrderData.OrderInfo.NAME_MAX_LENGTH)
    private String name;

    @Length(max = OrderData.OrderInfo.NAME_MAX_LENGTH)
    private String description;
}
