package app.web.orders.domain.element.element.event;

import app.web.orders.domainDrivenDesign.annotation.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;

@DomainEvent
@Getter
public class ElementProducerUpdated {
    private long elementId;
    private ProducerData oldProducer;
    private ProducerData newProducer;

    public ElementProducerUpdated(long elementId, long oldId, long newId, String oldName, String newName) {
        this.elementId = elementId;
        this.oldProducer = new ProducerData(oldId, oldName);
        this.newProducer = new ProducerData(newId, newName);
    }

    @AllArgsConstructor
    @Getter
    public class ProducerData {
        private long id;
        private String name;
    }
}
