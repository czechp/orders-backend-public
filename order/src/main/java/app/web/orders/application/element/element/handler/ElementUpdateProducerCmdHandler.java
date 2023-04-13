package app.web.orders.application.element.element.handler;

import app.web.orders.application.element.element.cmd.ElementUpdateProducerCmd;
import app.web.orders.domain.element.element.Element;
import app.web.orders.domain.element.element.ElementRepository;
import app.web.orders.domain.element.element.event.ElementProducerUpdated;
import app.web.orders.domain.element.producer.Producer;
import app.web.orders.domain.element.producer.ProducerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ElementUpdateProducerCmdHandler {
    private final ElementRepository elementRepository;
    private final ProducerRepository producerRepository;

    public ElementProducerUpdated updateProducer(ElementUpdateProducerCmd command) {
        Element element = elementRepository.findByIdOrThrowException(command.getElementId());
        Producer producer = producerRepository.findByIdOrException(command.getProducerId());
        ElementProducerUpdated elementProducerUpdated = element.updateProducer(producer.getSnap());
        return elementProducerUpdated;
    }
}
