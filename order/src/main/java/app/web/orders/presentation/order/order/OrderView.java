package app.web.orders.presentation.order.order;

import app.web.orders.domain.order.order.OrderState;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name = "orders_view")
@Immutable
@Data
class OrderView {
    @Id
    private long id;
    private LocalDateTime createdAt;
    private LocalDateTime executionDate;
    private LocalDateTime closingDate;
    private String owner;
    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    @OneToMany()
    @JoinColumn(name = "order_id")
    @OrderBy("producer asc,id asc")
    private Set<PositionView> positions = new HashSet<>();
    private String internalId;
}
