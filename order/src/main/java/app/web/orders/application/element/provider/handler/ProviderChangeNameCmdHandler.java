package app.web.orders.application.element.provider.handler;

import app.web.orders.domain.element.provider.Provider;
import app.web.orders.domain.element.provider.ProviderRepository;
import app.web.orders.domain.element.provider.event.ProviderNameChanged;
import app.web.orders.application.element.provider.command.ProviderChangeNameCmd;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
@Transactional
public class ProviderChangeNameCmdHandler {
    private final ProviderRepository providerRepository;

    public ProviderNameChanged changeName(ProviderChangeNameCmd changeNameCmd) {
        Provider provider = providerRepository.findByIdOrException(changeNameCmd.getProviderId());
        ProviderNameChanged providerNameChanged = provider.changeName(changeNameCmd.getNewName(), providerRepository::existsByName);
        return providerNameChanged;
    }
}
