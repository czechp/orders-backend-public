package app.web.orders.domain.order.order;

class PositionStateOrdered implements PositionStateBehaviours{
    @Override
    public void updateQuantity() {
        throw new IllegalStateException("Nie można zmieniać pozycji po zamówieniu");
    }

    @Override
    public void order() {
        throw new IllegalStateException("Można zamawiać tylko jeszcze niezamówioną pozycje");
    }

    @Override
    public void deliver() {}
}
