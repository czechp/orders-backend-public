package app.web.orders.presentation.order.order;

import app.web.orders.domain.order.order.PositionStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@NoArgsConstructor
@Table(name = "positions_details_view")
@Data
class PositionDetailsView {
    @Id
    private long id;
    private long orderId;
    private int quantity;
    private String positionUnit;
    private String name;
    private String producer;
    private String orderName;
    private String orderOwner;
    private String orderInternalId;
    @Enumerated(EnumType.STRING)
    private PositionStatus positionStatus;
    private String serialNumber;
}
