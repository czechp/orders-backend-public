package app.web.orders.domain.element.category.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CategoryRemoved {
    private final long providerId;
    private final String name;
}
