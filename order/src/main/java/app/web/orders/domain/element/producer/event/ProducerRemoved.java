package app.web.orders.domain.element.producer.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProducerRemoved {
    private final long producerId;
    private final String name;
}
