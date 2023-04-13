package app.web.orders.domain.order.order;

import app.web.orders.application.order.order.cmd.OrderRemoveCmd;
import app.web.orders.exception.order.OrderExceptions;
import org.springframework.data.repository.Repository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface OrderRepository extends Repository<OrderBasicImpl, Long> {
    Order save(Order order);

    Optional<Order> findById(long id);

    default Order findByIdOrThrowException(long orderId) {
        return findById(orderId)
                .orElseThrow(() -> OrderExceptions.notFoundException(orderId));
    }

    void removeById(long orderId);
}
