package app.web.orders.domain.element.category.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CategoryCreated {
    private final long id;
    private final String name;
}
