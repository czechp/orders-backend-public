package app.web.orders.domain.element.provider;

import app.web.orders.domain.element.provider.event.ProviderNameChanged;
import app.web.orders.domainDrivenDesign.annotation.AggregateRoot;
import app.web.orders.domain.element.provider.event.ProviderCreated;
import app.web.orders.domain.element.provider.event.ProviderRemoved;
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
@Table(name = "providers")
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@Getter(AccessLevel.PACKAGE)
public class Provider extends app.web.orders.domainDrivenDesign.superClassEntity.AggregateRoot {

    @NotNull
    @Length(min = ProviderConstraint.NAME_MIN_LENGTH, max = ProviderConstraint.NAME_MAX_LENGTH)
    private String name;

    Provider(String name) {
        setName(name);
    }

    private void setName(String name) {
        final var fieldName = "nazwa dostawcy";
        CommonValidators.validateNotNull(name, fieldName);
        CommonValidators.validateMinLength(name, 3, fieldName);
        this.name = name;
    }

    public ProviderCreated generateProviderCreatedEvent() {
        return ProviderFactory.createdEvent(this);
    }

    public ProviderNameChanged changeName(String newName, Predicate<String> providerExistsById) {
        if (providerExistsById.test(newName))
            throw new IllegalStateException(String.format("Dostawca z nazwa: %s już istnieje", name));
        ProviderNameChanged providerNameChanged = new ProviderNameChanged(this.name, newName);
        this.setName(newName);
        return providerNameChanged;
    }

    public ProviderRemoved generateProviderRemoveEvent() {
        return new ProviderRemoved(super.getId(), this.name);
    }

    public ProviderSnap getSnap() {
        return new ProviderSnap(super.getId(), this.getName());
    }
}
