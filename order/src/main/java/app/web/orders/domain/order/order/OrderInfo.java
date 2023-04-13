package app.web.orders.domain.order.order;

import app.web.orders.domainDrivenDesign.annotation.ValueObject;
import app.web.orders.validator.CommonValidators;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@ValueObject
@EqualsAndHashCode
@Embeddable
@NoArgsConstructor
@Getter(AccessLevel.PACKAGE)
class OrderInfo {
    private String name;
    private String description;

    public OrderInfo(String name, String description) {
        setName(name);
        setDescription(description);
    }

    private void setName(String name) {
        CommonValidators.validateMinLength(name,
                OrderData.OrderInfo.NAME_MIN_LENGTH,
                OrderData.OrderInfo.NAME);
        CommonValidators.validateMaxLength(name,
                OrderData.OrderInfo.NAME_MAX_LENGTH,
                OrderData.OrderInfo.NAME);
        this.name = name;
    }

    private void setDescription(String description) {
        CommonValidators.validateMaxLength(description,
                OrderData.OrderInfo.DESCRIPTION_MAX_LENGTH,
                OrderData.OrderInfo.DESCRIPTION);

        this.description = description;
    }
}
