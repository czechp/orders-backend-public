package app.web.orders.application.element.producer.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProducerRemoveCmd {
    private final long producerId;
}
