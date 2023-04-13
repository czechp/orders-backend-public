package app.web.orders.domain.order.order;

public class OrderFactory {
    public static Order order(String name, String description) {
        final var orderInfo = OrderFactory.orderInfo(name, description);
        return new OrderBasicImpl(orderInfo);
    }

    static OrderInfo orderInfo(String name, String description) {
        return new OrderInfo(name, description);
    }

    static Position position(long elementId, int quantity, PositionUnit positionUnit) {
        return new Position(elementId, positionQuantity(quantity, positionUnit));
    }

    private static  PositionQuantity positionQuantity(int quantity, PositionUnit positionUnit){
        return new PositionQuantity(quantity, positionUnit);
    }
}
