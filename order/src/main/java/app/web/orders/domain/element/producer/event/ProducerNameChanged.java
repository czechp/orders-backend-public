package app.web.orders.domain.element.producer.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProducerNameChanged {
    private final String oldName;
    private final String newName;
}
