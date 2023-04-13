package app.web.orders.domain.element.producer.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProducerCreated {
    private final long id;
    private final String name;
}
