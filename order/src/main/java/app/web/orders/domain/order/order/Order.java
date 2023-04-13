package app.web.orders.domain.order.order;

import app.web.orders.domain.order.order.event.*;

public interface Order {
    OrderInfoUpdated updateInfo(String name, String description);
    OrderPositionAdded addPosition(long elementId, int quantity, PositionUnit positionUnit);
    OrderPositionQuantityChanged changePositionQuantity(long positionId, int newQuantity);
    OrderPositionRemoved removePosition(long positionId);
    OrderReleasedToExecution releaseToExecution();
    OrderInternalIdDetermined determineInternalId(String internalId);

    OrderPositionOrdered  orderPosition(long positionId);
    OrderPositionDelivered deliverPosition(long positionId);
    OrderClosed close();
    OrderSnap orderSnap();
}
