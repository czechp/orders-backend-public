package app.web.orders.presentation.order.order;

import app.web.orders.domain.order.order.PositionStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;

@Entity
@Table(name = "positions_view")
@NoArgsConstructor
@Immutable
@Data
class PositionView {
    @Id
    private long id;
    private long quantity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String positionUnit;
    private String name;
    private String producer;
    private String category;
    private String provider;
    @Enumerated(EnumType.STRING)
    private PositionStatus positionStatus;
    private String url;
    private String description;
    private LocalDateTime orderingDate;
    private LocalDateTime deliveringDate;
    private String serialNumber;
}
