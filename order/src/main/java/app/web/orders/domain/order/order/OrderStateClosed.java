package app.web.orders.domain.order.order;

class OrderStateClosed implements OrderStateBehaviours {
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
        throw new IllegalStateException("Pozycje można usunąć tylko podczas przygotowania zamówienia");
    }

    @Override
    public void releaseToExecution() {
        throw new IllegalStateException("Zamówienie można przesłać do realizacji tylko podczas przygotowania");
    }

    @Override
    public void deliverPosition() {
        throw new IllegalStateException("Pozycję można ozanczyć jako dostraczona tylko podczas realizacji zamówienia");
    }
    @Override
    public void close() {
        throw new IllegalStateException("Zamówienie zostało już zamknięte");
    }

    @Override
    public void determineInternalId() {
        throw new IllegalStateException("Wewnetrznę id może ustawiać tylko podczas realizowania zamówienia");
    }

    @Override
    public void orderPosition() {
        throw new IllegalStateException("Pozycję można zamawiać tylko podczas realizacji zamówienia");
    }
}
