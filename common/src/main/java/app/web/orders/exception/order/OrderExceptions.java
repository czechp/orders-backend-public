package app.web.orders.exception.order;

import app.web.orders.exception.ElementNotFoundException;
import org.apache.catalina.User;

public class OrderExceptions {
    public static RuntimeException notFoundException(long orderId) {
        return new ElementNotFoundException(String.format("Zamówienie z id: %d nie istnieje", orderId));
    }
    public static RuntimeException userIsNotOwnerOfOrder(String username, long orderId){
        return new UserIsNotOwnerOfOrder(username, orderId);
    }

    public static RuntimeException positionNotFound(long orderId, long positionId) {
        return new ElementNotFoundException(String.format("Zamówienie z id: %d nie ma pozycji z id: %d", orderId, positionId));
    }
}
