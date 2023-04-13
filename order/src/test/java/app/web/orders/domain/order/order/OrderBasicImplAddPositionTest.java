package app.web.orders.domain.order.order;

import app.web.orders.domain.order.order.event.OrderPositionAdded;
import app.web.orders.domain.order.order.event.OrderPositionQuantityChanged;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderBasicImplAddPositionTest {

    @Test
    @DisplayName("Order.addPosition() - empty collection")
    void addPositionEmptyCollectionTest() {
        //given
        Order order = OrderBasicImpl.builder()
                .withPositions(new HashSet<>())
                .withAllowedBehaviour(new OrderStatePreparation())
                .build();
        long elementId = 1L;
        int quantity = 10;
        PositionUnit positionUnit = PositionUnit.PCS;
        //when
        OrderPositionAdded orderPositionAdded = order.addPosition(elementId, quantity, positionUnit);
        OrderBasicImpl orderAfterAdding = (OrderBasicImpl) order;
        //then
        assertEquals(1, orderAfterAdding.getPositions().size());
    }

    @Test
    @DisplayName("Order.addPosition() - position with such elementId already exists")
    void addPositionAlreadyExistsTest() {
        //given
        long elementId = 1L;
        Set<Position> positions = new HashSet<>();
        positions.add(OrderFactory.position(elementId, 10, PositionUnit.PCS));
        OrderBasicImpl order = OrderBasicImpl.builder()
                .withPositions(positions)
                .withAllowedBehaviour(new OrderStatePreparation())
                .build();
        //when
        OrderPositionAdded orderPositionAdded = order.addPosition(elementId, 10, PositionUnit.PCS);
        //then
        assertEquals(1, order.getPositions().size());
        Integer positionQuantity = order.getPositions()
                .stream()
                .filter(x -> x.getElementId() == elementId)
                .map(x -> x.getPositionQuantity().getQuantity())
                .findAny()
                .orElseThrow(() -> new IllegalStateException(String.format("Element with id: %d nie istnieje")));
        assertEquals(20, positionQuantity);
    }

    @Test
    @DisplayName("Order.addPosition() - position unit not match")
    void addPositionUnitNotMatchTest() {
        //given
        long elementId = 1L;
        Set<Position> positions = new HashSet<>();
        positions.add(OrderFactory.position(elementId, 10, PositionUnit.PCS));
        OrderBasicImpl order = OrderBasicImpl.builder()
                .withPositions(positions)
                .withAllowedBehaviour(new OrderStatePreparation())
                .build();
        //when
        assertThrows(IllegalArgumentException.class, () -> order.addPosition(elementId, 10, PositionUnit.METRES));
        //then
        ;
    }

    @Test
    @DisplayName("Order.changePositionQuantity() - ok")
    void changePositionQuantityTest() {
        //given - user create order and add new position to order
        OrderBasicImpl order = OrderBasicImpl.builder()
                .withAllowedBehaviour(new OrderStatePreparation())
                .withPositions(new HashSet<>())
                .build();
        order.addPosition(1L, 10, PositionUnit.PCS);
        //when - user change quantity for previously added position
        OrderPositionQuantityChanged orderPositionQuantityChanged = order.changePositionQuantity(0L, 20);
        //then - new quantity in selected position should be 20
        assertEquals(20, order.getPositions().stream().findAny().get().getPositionQuantity().getQuantity());
    }
}