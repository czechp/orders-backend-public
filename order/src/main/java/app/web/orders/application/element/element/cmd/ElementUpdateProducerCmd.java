package app.web.orders.application.element.element.cmd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ElementUpdateProducerCmd {
    private long elementId;
    private long producerId;
}
