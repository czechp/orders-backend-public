package app.web.orders.domain.element.element.event;

import app.web.orders.domainDrivenDesign.annotation.DomainEvent;
import lombok.AllArgsConstructor;

@DomainEvent
@AllArgsConstructor
public class ElementAssociatedElementAdded {
    private long elementId;
    private long addedElementId;
}
