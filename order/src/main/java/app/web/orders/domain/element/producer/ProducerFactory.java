package app.web.orders.domain.element.producer;

import app.web.orders.domain.element.producer.event.ProducerCreated;

import java.util.function.Predicate;

public class ProducerFactory {
    public static Producer producer(String name, Predicate<String> producerExistsByName) {
        if (producerExistsByName.test(name))
            throw new IllegalStateException(String.format("Producent z nazwą: %s już istnieje", name));
        return new Producer(name);
    }

    static ProducerCreated createdEvent(Producer producer) {
        return new ProducerCreated(producer.getId(), producer.getName());
    }
}
