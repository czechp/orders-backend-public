package app.web.orders.domain.order.order;

class PositionStateNotOrdered implements PositionStateBehaviours{
    @Override
    public void updateQuantity() {}

    @Override
    public void order() {}

    @Override
    public void deliver() {
        throw new IllegalStateException("Nie można dostaczyć nie zamówionej pozycji");
    }
}
