package app.web.orders.domain.order.order;

import app.web.orders.domainDrivenDesign.annotation.DomainEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = OrderData.POSITION_TABLE_NAME)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DomainEntity
@Getter(AccessLevel.PACKAGE)
class Position extends app.web.orders.domainDrivenDesign.superClassEntity.Entity {
    private long elementId;
    @Embedded
    private PositionQuantity positionQuantity;
    @Enumerated(EnumType.STRING)
    private PositionStatus positionStatus;
    @Transient
    private PositionStateBehaviours allowedBehaviours;
    private LocalDateTime orderingDate;
    private LocalDateTime deliveringDate;

    Position(long elementId, PositionQuantity positionQuantity) {
        setElementId(elementId);
        this.positionQuantity = positionQuantity;
        this.positionStatus = PositionStatus.NOT_ORDERED;
        this.allowedBehaviours = new PositionStateNotOrdered();
    }

    @PostLoad
    public void init() {
        switch (positionStatus){
            case NOT_ORDERED -> this.allowedBehaviours = new PositionStateNotOrdered();
            case ORDERED -> this.allowedBehaviours = new PositionStateOrdered();
            case DELIVERED -> this.allowedBehaviours = new PositionStateDelivered();
        }
    }

    private void setElementId(long elementId) {
        if (elementId <= 0)
            throw new IllegalArgumentException(String.format("Nie poprawne id dla elementu: %d", elementId));
        this.elementId = elementId;
    }

    void updateQuantity(int quantity, PositionUnit positionUnit) {
        this.allowedBehaviours.updateQuantity();
        this.positionQuantity = positionQuantity.updateQuantity(quantity, positionUnit);
    }


    public void updateQuantity(int quantity) {
        this.allowedBehaviours.updateQuantity();
        this.positionQuantity = positionQuantity.updateQuantity(quantity);
    }

    public void order() {
        this.allowedBehaviours.order();
        this.orderingDate = LocalDateTime.now();
        this.positionStatus = PositionStatus.ORDERED;
        this.allowedBehaviours = new PositionStateOrdered();
    }

    public void deliver() {
        this.allowedBehaviours.deliver();
        this.deliveringDate = LocalDateTime.now();
        this.positionStatus = PositionStatus.DELIVERED;
        this.allowedBehaviours = new PositionStateDelivered();
    }
}
