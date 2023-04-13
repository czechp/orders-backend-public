package app.web.orders.domain.element.provider.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProviderRemoved {
    private final long providerId;
    private final String name;
}
