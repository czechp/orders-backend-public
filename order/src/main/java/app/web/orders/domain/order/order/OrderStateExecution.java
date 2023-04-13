package app.web.orders.domain.order.order;

class OrderStateExecution implements OrderStateBehaviours {
    @Override
    public void updateInfo() {
        throw new IllegalStateException("Dane można zmieniać tylko podczas przygotowania zamówienia");
    }

    @Override
    public void addPosition() {
        throw new IllegalStateException("Pozycje można dodawac tylko podczas przygotowania zamówienia");
    }

    @Override
    public void changeQuantity() {
        throw new IllegalStateException("Ilość można zmieniać tylko podczas przygotowanie zamówienia");
    }

    @Override
    public void removePosition() {
        throw new IllegalStateException("Pozycje można usunąc tylko podczas przygotowania zamówienia");
    }

    @Override
    public void releaseToExecution() {
        throw new IllegalStateException("Zamówienie można przesłać do realizacji tylko podczas przygotowania");
    }

    @Override
    public void determineInternalId() {}

    @Override
    public void orderPosition() {}

    @Override
    public void deliverPosition() {}

    @Override
    public void close() {}
}
