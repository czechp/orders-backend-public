package app.web.orders.domain.order.order;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class OrderSnap {
    long id;
    private String owner;
    private String name;
}
