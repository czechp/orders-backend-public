package app.web.orders.domain.order.order;

import app.web.orders.domain.order.order.event.*;
import app.web.orders.domainDrivenDesign.annotation.AggregateRoot;
import app.web.orders.exception.order.OrderExceptions;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = OrderData.ORDER_TABLE_NAME)
@NoArgsConstructor
@AggregateRoot
@DynamicUpdate
@Getter(AccessLevel.PACKAGE)
@Builder(setterPrefix = "with", access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class OrderBasicImpl extends app.web.orders.domainDrivenDesign.superClassEntity.AggregateRoot implements Order {
    @Transient
    private OrderStateBehaviours allowedBehaviour;
    @Embedded
    private OrderInfo orderInfo;
    private LocalDateTime executionDate;
    private LocalDateTime closingDate;
    @Enumerated(EnumType.STRING)
    private OrderState orderState;
    @Embedded
    private OrderInternalId orderInternalId;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private Set<Position> positions = new HashSet<>();

    OrderBasicImpl(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
        this.allowedBehaviour = new OrderStatePreparation();
        this.orderState = OrderState.PREPARATION;
    }

    @Override
    public OrderInfoUpdated updateInfo(String name, String description) {
        this.allowedBehaviour.updateInfo();
        this.orderInfo = OrderFactory.orderInfo(name, description);
        return new OrderInfoUpdated(super.getId(), name, description);
    }

    @Override
    public OrderPositionAdded addPosition(long elementId, int quantity, PositionUnit positionUnit) {
        allowedBehaviour.addPosition();
        positions
                .stream()
                .filter(position -> position.getElementId() == elementId)
                .findAny()
                .ifPresentOrElse(
                        position -> position.updateQuantity(quantity, positionUnit),
                        () -> this.positions.add(OrderFactory.position(elementId, quantity, positionUnit))
                );


        return new OrderPositionAdded(super.getId(), elementId, quantity, positionUnit);
    }

    @Override
    public OrderSnap orderSnap() {
        return new OrderSnap(getId(), getCreatedBy(), orderInfo.getName());
    }

    @Override
    public OrderPositionQuantityChanged changePositionQuantity(long positionId, int newQuantity) {
        this.allowedBehaviour.changeQuantity();
        Position positionToUpdate = findPositionByIdOrException(positionId);

        positionToUpdate.updateQuantity(newQuantity);
        return new OrderPositionQuantityChanged(getId(), positionId, newQuantity);
    }

    @Override
    public OrderPositionRemoved removePosition(long positionId) {
        this.allowedBehaviour.removePosition();
        Position positionToRemove = findPositionByIdOrException(positionId);
        positions.remove(positionToRemove);
        return new OrderPositionRemoved(getId(), positionId);
    }

    @Override
    public OrderReleasedToExecution releaseToExecution() {
        this.allowedBehaviour.releaseToExecution();
        this.orderState = OrderState.EXECUTION;
        this.allowedBehaviour = new OrderStateExecution();
        this.executionDate = LocalDateTime.now();
        return new OrderReleasedToExecution(getId());
    }

    @Override
    public OrderInternalIdDetermined determineInternalId(String internalId) {
        this.allowedBehaviour.determineInternalId();
        this.orderInternalId = OrderInternalId.of(internalId);
        return new OrderInternalIdDetermined(getId(), internalId);
    }

    @Override
    public OrderPositionOrdered orderPosition(long positionId) {
        Position positionToOrder = findPositionByIdOrException(positionId);
        positionToOrder.order();
        return new OrderPositionOrdered(getId(), positionId);
    }

    @Override
    public OrderClosed close() {
        this.allowedBehaviour.close();
        boolean allPositionsClosed = positions
                .stream()
                .allMatch(position -> position.getPositionStatus() == PositionStatus.DELIVERED);
        if (!allPositionsClosed)
            throw new IllegalStateException("Aby zamknąć zamówienie wszystkie pozyjce muszą być dostarczone");
        this.closingDate = LocalDateTime.now();
        this.orderState = OrderState.CLOSED;
        this.allowedBehaviour = new OrderStateClosed();
        return new OrderClosed(getId());
    }

    private Position findPositionByIdOrException(long positionId) {
        return positions
                .stream()
                .filter(position -> position.getId() == positionId)
                .findAny()
                .orElseThrow(() -> OrderExceptions.positionNotFound(getId(), positionId));
    }

    @Override
    public OrderPositionDelivered deliverPosition(long positionId) {
        Position positionToDeliver = findPositionByIdOrException(positionId);
        positionToDeliver.deliver();
        return new OrderPositionDelivered(getId(), positionId);
    }

    @PostLoad
    void init() {
        switch (orderState) {
            case PREPARATION -> this.allowedBehaviour = new OrderStatePreparation();
            case EXECUTION -> this.allowedBehaviour = new OrderStateExecution();
            case CLOSED -> this.allowedBehaviour = new OrderStateClosed();
        }
    }
}
