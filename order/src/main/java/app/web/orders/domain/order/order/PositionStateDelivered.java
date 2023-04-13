package app.web.orders.domain.order.order;

class PositionStateDelivered implements PositionStateBehaviours{
    @Override
    public void updateQuantity() {
        throw new IllegalStateException("Nie można modyfikować zamkniętej pozycji");
    }

    @Override
    public void order() {
        throw new IllegalStateException("Można zamawiać tylko jeszcze niezamówioną pozycje");
    }

    @Override
    public void deliver() {
        throw new IllegalStateException("Pozycja została już dostarczone");

    }
}
