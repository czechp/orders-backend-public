package app.web.orders.domain.order.order.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public
class OrderInternalIdDetermined {
    private final long orderId;
    private final String internalId;
}
