package app.web.orders.application.element.element.handler;

import app.web.orders.application.element.element.cmd.ElementUpdateProviderCmd;
import app.web.orders.domain.element.element.Element;
import app.web.orders.domain.element.element.ElementRepository;
import app.web.orders.domain.element.provider.Provider;
import app.web.orders.domain.element.provider.ProviderRepository;
import app.web.orders.domain.element.element.event.ElementProviderUpdated;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ElementUpdateProviderCmdHandler {
    private final ElementRepository elementRepository;
    private final ProviderRepository providerRepository;

    public ElementProviderUpdated updateProvider(ElementUpdateProviderCmd command) {
        Element element = elementRepository.findByIdOrThrowException(command.getElementId());
        Provider provider = providerRepository.findByIdOrException(command.getProviderId());
        ElementProviderUpdated elementProviderUpdated = element.updateProvider(provider.getSnap());
        return elementProviderUpdated;
    }
}
