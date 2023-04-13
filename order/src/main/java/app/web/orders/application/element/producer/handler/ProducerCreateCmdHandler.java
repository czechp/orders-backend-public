package app.web.orders.application.element.producer.handler;

import app.web.orders.application.element.producer.command.ProducerCreateCmd;
import app.web.orders.domain.element.producer.event.ProducerCreated;
import app.web.orders.domain.element.producer.Producer;
import app.web.orders.domain.element.producer.ProducerFactory;
import app.web.orders.domain.element.producer.ProducerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class ProducerCreateCmdHandler {
    private final ProducerRepository producerRepository;

    public ProducerCreated createCategory(ProducerCreateCmd producerCreateCmd) {
        Producer producer = ProducerFactory.producer(producerCreateCmd.getName(), producerRepository::existsByName);
        Producer persistedProducer = producerRepository.save(producer);
        return persistedProducer.generateProducerCreatedEvent();
    }
}
