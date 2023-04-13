package app.web.orders.presentation.order.order;

import app.web.orders.domain.order.order.OrderBasicImpl;
import app.web.orders.domain.order.order.OrderState;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

interface OrderViewRepository extends JpaRepository<OrderView, Long> {
    @Query("select o from OrderView o left join fetch o.positions where o.orderState=:orderState")
    List<OrderView> findViewByOrderState(OrderState orderState, Sort sort);
    @Query("select o from OrderView o left join fetch o.positions p where o.id=:id")
    Optional<OrderView> findViewById(long id);
    @Query("select o from OrderView o left join fetch o.positions where o.owner=:owner and o.orderState=:orderState")
    List<OrderView> findByOwnerAndOrderState(String owner, OrderState orderState, Sort sort);
}
