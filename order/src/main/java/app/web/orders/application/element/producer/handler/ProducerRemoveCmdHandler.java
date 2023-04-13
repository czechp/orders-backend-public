package app.web.orders.application.element.producer.handler;

import app.web.orders.application.element.producer.command.ProducerRemoveCmd;
import app.web.orders.domain.element.producer.event.ProducerRemoved;
import app.web.orders.domain.element.producer.Producer;
import app.web.orders.domain.element.producer.ProducerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ProducerRemoveCmdHandler {
    private final ProducerRepository producerRepository;

    public ProducerRemoved removeProducer(ProducerRemoveCmd producerRemoveCmd) {
        Producer producerToRemove = producerRepository.findByIdOrException(producerRemoveCmd.getProducerId());
        ProducerRemoved producerRemoved = producerToRemove.generateCategoryRemoveEvent();
        producerRepository.delete(producerToRemove);
        return producerRemoved;
    }
}
