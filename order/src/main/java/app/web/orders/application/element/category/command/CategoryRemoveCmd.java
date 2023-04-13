package app.web.orders.application.element.category.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CategoryRemoveCmd {
    private final long providerId;
}
