package app.web.orders.domain.order.order;

import app.web.orders.validator.CommonValidators;
import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Embeddable
class OrderInternalId {
    private String internalId;

    private OrderInternalId(String internalId) {
        this.internalId = internalId;
    }

    static OrderInternalId of(String internalId) {
        CommonValidators.validateNotNull(internalId, "wewnętrzne id");
        return new OrderInternalId(internalId);
    }
}
