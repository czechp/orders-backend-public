package app.web.orders.domain.element.category;

import app.web.orders.domain.element.category.event.CategoryCreated;
import app.web.orders.domain.element.category.event.CategoryNameChanged;
import app.web.orders.domain.element.category.event.CategoryRemoved;
import app.web.orders.domainDrivenDesign.annotation.AggregateRoot;
import app.web.orders.validator.CommonValidators;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import java.util.function.Predicate;

@AggregateRoot
@Entity
@Table(name = "categories")
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@Getter(AccessLevel.PACKAGE)
public class Category extends app.web.orders.domainDrivenDesign.superClassEntity.AggregateRoot {
    @NotNull
    @Length(min = CategoryConstraint.NAME_MIN_LENGTH, max = CategoryConstraint.NAME_MAX_LENGTH)
    private String name;

    Category(String name) {
        super();
        setName(name);
    }

    private void setName(String name) {
        final var fieldName = "nazwa kategorii";
        CommonValidators.validateNotNull(name, fieldName);
        CommonValidators.validateMinLength(name, 3, fieldName);
        this.name = name;
    }

    public CategoryCreated generateCategoryCreatedEvent() {
        return CategoryFactory.createdEvent(this);
    }

    public CategoryNameChanged changeName(String newName, Predicate<String> providerExistsById) {
        if (providerExistsById.test(newName))
            throw new IllegalStateException(String.format("Kategoria z nazwa: %s już istnieje", name));
        CategoryNameChanged categoryNameChanged = new CategoryNameChanged(this.name, newName);
        this.setName(newName);
        return categoryNameChanged;
    }

    public CategoryRemoved generateCategoryRemoveEvent() {
        return new CategoryRemoved(super.getId(), this.name);
    }

    public CategorySnap getSnap() {
        return new CategorySnap(super.getId(), this.getName());
    }
}
