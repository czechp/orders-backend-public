package app.web.orders.domain.element.provider.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProviderNameChanged {
    private final String oldName;
    private final String newName;
}
