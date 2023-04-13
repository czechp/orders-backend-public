package app.web.orders.application.element.element.handler;

import app.web.orders.application.element.element.cmd.ElementCreateCmd;
import app.web.orders.domain.element.category.CategorySnap;
import app.web.orders.domain.element.provider.ProviderRepository;
import app.web.orders.domain.element.provider.ProviderSnap;
import app.web.orders.domain.element.category.CategoryRepository;
import app.web.orders.domain.element.element.ElementFactory;
import app.web.orders.domain.element.element.ElementRepository;
import app.web.orders.domain.element.element.event.ElementCreated;
import app.web.orders.domain.element.element.Element;
import app.web.orders.exception.element.ElementExceptions;
import app.web.orders.domain.element.producer.ProducerRepository;
import app.web.orders.domain.element.producer.ProducerSnap;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class ElementCreateCmdHandler {
    private final ElementRepository elementRepository;
    private final ProducerRepository producerRepository;
    private final CategoryRepository categoryRepository;
    private final ProviderRepository providerRepository;

    public ElementCreated createElement(ElementCreateCmd elementCreateCmd) {
        if (elementRepository.existsByElementInfoSerialNumber(elementCreateCmd.getSerialNumber()))
            throw ElementExceptions.existsWithSameSerialNumber(elementCreateCmd.getSerialNumber());

        ProducerSnap producerSnap = producerRepository.findByIdOrException(elementCreateCmd.getProducerId()).getSnap();
        CategorySnap categorySnap = categoryRepository.findByIdOrException(elementCreateCmd.getCategoryId()).getSnap();
        ProviderSnap providerSnap = providerRepository.findByIdOrException(elementCreateCmd.getProviderId()).getSnap();

        Element element = ElementFactory.element(
                elementCreateCmd.getName(),
                elementCreateCmd.getDescription(),
                elementCreateCmd.getSerialNumber(),
                elementCreateCmd.getUrl(),
                producerSnap,
                categorySnap,
                providerSnap);
        Element persistedElement = elementRepository.saveElement(element);

        return persistedElement.createEvent();
    }
}
