package app.web.orders.domain.element.element.event;

import app.web.orders.domainDrivenDesign.annotation.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;

@DomainEvent
@Getter
public class ElementCategoryUpdated {
    private long elementId;
    private CategoryData oldCategory;
    private CategoryData newCategory;

    public ElementCategoryUpdated(long elementId, long oldId, long newId, String oldName, String newName) {
        this.elementId = elementId;
        this.oldCategory = new CategoryData(oldId, oldName);
        this.newCategory = new CategoryData(newId, newName);
    }

    @AllArgsConstructor
    @Getter
    public class CategoryData {
        private long id;
        private String name;
    }
}
