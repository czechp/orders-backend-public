package app.web.orders.domain.order.order;

import app.web.orders.domain.order.order.event.OrderClosed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderBasicImplCloseTest {

    @Test
    @DisplayName("Order.close() - ok")
    void closeTest() {
        //given - User create order
        OrderBasicImpl order = (OrderBasicImpl) OrderFactory.order("New order", "Some empty description");
        //and - add some position
        order.addPosition(1L, 10, PositionUnit.PCS);
        order.addPosition(2L, 20, PositionUnit.METRES);
        //and - expose to execution
        order.releaseToExecution();
        //and - order and deliver all position
        order.getPositions().forEach(Position::order);
        order.getPositions().forEach(Position::deliver);
        //when
        OrderClosed orderClosed = order.close();
        //then
        assertNotNull(orderClosed);
        assertEquals(OrderState.CLOSED, order.getOrderState());
    }

    @Test
    @DisplayName("Order.close() - nok exists not delivered positions")
    void closeHasNotDeliveredPositionTest() {
        //given - User create order
        OrderBasicImpl order = (OrderBasicImpl) OrderFactory.order("New order", "Some empty description");
        //and - add some position
        order.addPosition(1L, 10, PositionUnit.PCS);
        order.addPosition(2L, 20, PositionUnit.METRES);
        //and - expose to execution
        order.releaseToExecution();
        //and - order
        order.getPositions().forEach(Position::order);
        //when
        //then
        assertThrows(IllegalStateException.class, () -> {
            order.close();
        });
    }
}