package app.web.orders.domain.order.order;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
@Getter(AccessLevel.PACKAGE)
class PositionQuantity {
    private int quantity;
    @Enumerated(EnumType.STRING)
    private PositionUnit positionUnit;

    public PositionQuantity(int quantity, PositionUnit positionUnit) {
        this.quantity = quantity;
        this.positionUnit = positionUnit;
    }

    private void setQuantity(int quantity) {
        if (quantity <= 0)
            throw new IllegalArgumentException("Ilość musi być większa od zera");
        this.quantity = quantity;
    }

    PositionQuantity updateQuantity(int quantity, PositionUnit positionUnit) {
        boolean unitsNotMatch = !this.positionUnit.equals(positionUnit);
        if (unitsNotMatch)
            throw new IllegalArgumentException("Pozycja ma różne jednostki");
        return new PositionQuantity(this.quantity + quantity, this.positionUnit);
    }

    PositionQuantity updateQuantity(int quantity) {
        return new PositionQuantity(quantity, this.positionUnit);
    }
}
