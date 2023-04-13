package app.web.orders.domain.element.element.event;

import app.web.orders.domainDrivenDesign.annotation.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;

@DomainEvent
@AllArgsConstructor
@Getter
public
class ElementCreated {
    private final long elementId;
    private final String name;
    private final String description;
    private final String serialNumber;
    private final String url;
}
