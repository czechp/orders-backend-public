package app.web.orders.domain.element.provider;

import app.web.orders.domain.element.provider.event.ProviderCreated;

import java.util.function.Predicate;

public class ProviderFactory {
    public static Provider provider(String name, Predicate<String> providerExistsById) {
        if (providerExistsById.test(name))
            throw new IllegalStateException(String.format("Dostawca z nazwa: %s już istnieje", name));
        return new Provider(name);
    }

    static ProviderCreated createdEvent(Provider provider) {
        return new ProviderCreated(provider.getId(), provider.getName());
    }
}
