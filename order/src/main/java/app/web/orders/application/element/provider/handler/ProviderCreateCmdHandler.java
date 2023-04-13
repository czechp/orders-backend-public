package app.web.orders.application.element.provider.handler;

import app.web.orders.domain.element.provider.Provider;
import app.web.orders.domain.element.provider.ProviderFactory;
import app.web.orders.domain.element.provider.ProviderRepository;
import app.web.orders.domain.element.provider.event.ProviderCreated;
import app.web.orders.application.element.provider.command.ProviderCreateCmd;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class ProviderCreateCmdHandler {
    private final ProviderRepository providerRepository;

    public ProviderCreated createProvider(ProviderCreateCmd providerCreateCmd) {
        Provider provider = ProviderFactory.provider(providerCreateCmd.getName(), providerRepository::existsByName);
        Provider persistedProvider = providerRepository.save(provider);
        return persistedProvider.generateProviderCreatedEvent();
    }
}
