package app.web.orders.presentation.order.order;

import app.web.orders.domain.order.order.PositionStatus;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface PositionDetailsViewRepository extends JpaRepository<PositionDetailsView, Long> {
    List<PositionDetailsView> findByPositionStatus(PositionStatus positionStatus, Sort sort);

    @Query("""
            select view from PositionDetailsView view where 
            (upper(view.producer) like concat('%',upper(:pattern),'%') or
            upper(view.name) like concat('%',upper(:pattern),'%') or
            upper(view.serialNumber) like concat('%',upper(:pattern),'%'))
            and view.positionStatus=:positionStatus 
            """)
    List<PositionDetailsView> filterPositionsByPattern(String pattern, PositionStatus positionStatus, Sort sort);
}
