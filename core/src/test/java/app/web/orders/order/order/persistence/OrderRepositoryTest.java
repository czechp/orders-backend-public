package app.web.orders.order.order.persistence;

import app.web.orders.exception.ElementNotFoundException;
import app.web.orders.domain.order.order.Order;
import app.web.orders.domain.order.order.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
@ActiveProfiles({"test"})
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    @DisplayName("OrderRepository.findByIdOrThrowException() - ok")
    @Sql("/testSql/orderRepositoryFindByIdTest.sql")
    void findByIdOrThrowExceptionTest() {
        //given
        long id = 1L;
        //when
        Order order = orderRepository.findByIdOrThrowException(id);
        //then
    }

    @Test
    @DisplayName("OrderRepository.findByIdOrThrowException() - nok not found")
    @Sql("/testSql/orderRepositoryFindByIdTest.sql")
    void findByIdOrThrowExceptionNotFoundTest() {
        //given
        long id = 1L;
        //when
        //then
        assertThrows(ElementNotFoundException.class, () -> orderRepository.findByIdOrThrowException(1L));
    }
}