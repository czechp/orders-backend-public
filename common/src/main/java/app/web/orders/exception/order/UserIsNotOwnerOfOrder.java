package app.web.orders.exception.order;

public class UserIsNotOwnerOfOrder extends RuntimeException{
    public UserIsNotOwnerOfOrder(String username, long orderId) {
        super(String.format("Użytkownik %s nie jest właścicielem zamówienia o id: %i", username, orderId));
    }
}
