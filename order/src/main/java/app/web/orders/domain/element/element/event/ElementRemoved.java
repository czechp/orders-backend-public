package app.web.orders.domain.element.element.event;

import app.web.orders.domainDrivenDesign.annotation.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;

@DomainEvent
@AllArgsConstructor
@Getter
public
class ElementRemoved {
    private final long elementId;
}
