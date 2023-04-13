package app.web.orders.presentation.order.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PositionViewRepository extends JpaRepository<PositionView, Long> {
}
