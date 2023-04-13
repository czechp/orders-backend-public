package app.web.orders.domain.order.order;

interface PositionStateBehaviours {
    void updateQuantity();
    void order();

    void deliver();
}
