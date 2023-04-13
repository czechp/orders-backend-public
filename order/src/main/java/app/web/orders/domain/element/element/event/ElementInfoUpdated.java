package app.web.orders.domain.element.element.event;

import app.web.orders.domainDrivenDesign.annotation.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;

@DomainEvent
@Getter
public class ElementInfoUpdated extends app.web.orders.domainDrivenDesign.superClass.DomainEvent {
    private long elementId;
    private Data oldData;
    private Data newData;

    public ElementInfoUpdated(long elementId) {
        this.elementId = elementId;
    }

    public void setOldData(String name, String description, String serialNumber, String url) {
        this.oldData = new Data(name, description, serialNumber, url);
    }


    public void setNewData(String name, String description, String serialNumber, String url) {
        this.newData = new Data(name, description, serialNumber, url);
    }

    @AllArgsConstructor
    @Getter
    public class Data {
        private String name;
        private String description;
        private String serialNumber;
        private String url;
    }
}
