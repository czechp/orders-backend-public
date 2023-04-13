package app.web.orders.domain.element.element.event;

import app.web.orders.domainDrivenDesign.annotation.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;

@DomainEvent
@Getter
public class ElementProviderUpdated {
    private long elementId;
    private ProviderData oldProvider;
    private ProviderData newProvider;

    public ElementProviderUpdated(long elementId, long oldId, long newId, String oldName, String newName) {
        this.elementId = elementId;
        this.oldProvider = new ProviderData(oldId, oldName);
        this.newProvider = new ProviderData(newId, newName);
    }

    @AllArgsConstructor
    @Getter
    public class ProviderData {
        private long id;
        private String name;
    }
}
