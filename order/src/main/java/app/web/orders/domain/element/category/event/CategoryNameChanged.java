package app.web.orders.domain.element.category.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CategoryNameChanged {
    private final String oldName;
    private final String newName;
}
