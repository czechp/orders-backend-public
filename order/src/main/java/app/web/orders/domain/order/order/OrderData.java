package app.web.orders.domain.order.order;

public class OrderData {
    public static final String ORDER_TABLE_NAME ="orders";
    public static final String POSITION_TABLE_NAME ="positions";
    public static class OrderInfo {
        static final String NAME = "nazwa zamówienia";
        public static final int NAME_MIN_LENGTH = 3;
        public static final int NAME_MAX_LENGTH = 50;

        static final String DESCRIPTION = "opis zamówienia";
        public final static int DESCRIPTION_MAX_LENGTH = 100;

    }
}
