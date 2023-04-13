package app.web.orders.application.element.provider.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProviderRemoveCmd {
    private final long providerId;
}
