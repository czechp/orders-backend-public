package app.web.orders.domain.order.order;

interface OrderStateBehaviours {
    void updateInfo();
    void addPosition();
    void changeQuantity();
    void removePosition();
    void releaseToExecution();
    void determineInternalId();
    void orderPosition();
    void deliverPosition();
    void close();

}
