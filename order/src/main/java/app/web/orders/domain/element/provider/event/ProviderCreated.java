package app.web.orders.domain.element.provider.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProviderCreated {
    private final long id;
    private final String name;
}
