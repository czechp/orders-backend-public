package app.web.orders.application.element.producer.handler;

import app.web.orders.application.element.producer.command.ProducerChangeNameCmd;
import app.web.orders.domain.element.producer.event.ProducerNameChanged;
import app.web.orders.domain.element.producer.Producer;
import app.web.orders.domain.element.producer.ProducerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
@Transactional
public class ProducerChangeNameCmdHandler {
    private final ProducerRepository producerRepository;

    public ProducerNameChanged changeName(ProducerChangeNameCmd changeNameCmd) {
        Producer producer = producerRepository.findByIdOrException(changeNameCmd.getProducerId());
        ProducerNameChanged producerNameChanged = producer.changeName(changeNameCmd.getNewName(), producerRepository::existsByName);
        return producerNameChanged;
    }
}
