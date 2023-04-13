package app.web.orders.exception.element;

import app.web.orders.exception.ElementNotFoundException;

public class ElementExceptions {
    public static RuntimeException notFound(long id) {
        return new ElementNotFoundException(String.format("Element z id %d nie istnieje", id));
    }

    public static RuntimeException existsWithSameSerialNumber(String serialNumber) {
        return new IllegalStateException(String.format("Element z numerem seryjnym: %s już istnieje", serialNumber));
    }
}
