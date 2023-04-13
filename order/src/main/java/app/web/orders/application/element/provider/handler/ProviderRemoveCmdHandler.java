package app.web.orders.application.element.provider.handler;

import app.web.orders.application.element.provider.command.ProviderRemoveCmd;
import app.web.orders.domain.element.provider.Provider;
import app.web.orders.domain.element.provider.ProviderRepository;
import app.web.orders.domain.element.provider.event.ProviderRemoved;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ProviderRemoveCmdHandler {
    private final ProviderRepository providerRepository;

    public ProviderRemoved removeProvider(ProviderRemoveCmd providerRemoveCmd) {
        Provider providerToRemove = providerRepository.findByIdOrException(providerRemoveCmd.getProviderId());
        ProviderRemoved providerRemoved = providerToRemove.generateProviderRemoveEvent();
        providerRepository.delete(providerToRemove);
        return providerRemoved;
    }
}
