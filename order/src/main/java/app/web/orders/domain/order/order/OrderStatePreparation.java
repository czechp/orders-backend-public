package app.web.orders.domain.order.order;

class OrderStatePreparation implements OrderStateBehaviours {
    @Override
    public void updateInfo() {
    }

    @Override
    public void addPosition() {
    }

    @Override
    public void changeQuantity() {
    }

    @Override
    public void removePosition() {
    }

    @Override
    public void releaseToExecution() {
    }

    @Override
    public void determineInternalId() {
        throw new IllegalStateException("Wewnetrznę ide może ustawiać tylko podczas realizowania zamówienia");
    }

    @Override
    public void orderPosition() {
        throw new IllegalStateException("Pozycję można zamawiać tylko podczas realizacji zamówienia");
    }

    @Override
    public void deliverPosition() {
        throw new IllegalStateException("Pozycję można ozanczyć jako dostraczona tylko podczas realizacji zamówienia");
    }

    @Override
    public void close() {
        throw new IllegalStateException("Nie można zamknąć zamówienia w trakcie przygotowania");
    }
}
