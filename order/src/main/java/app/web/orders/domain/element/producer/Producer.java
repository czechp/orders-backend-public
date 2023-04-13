package app.web.orders.domain.element.producer;

import app.web.orders.domain.element.producer.event.ProducerCreated;
import app.web.orders.domain.element.producer.event.ProducerNameChanged;
import app.web.orders.domain.element.producer.event.ProducerRemoved;
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
@Table(name = "producers")
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@Getter(AccessLevel.PACKAGE)
public class Producer extends app.web.orders.domainDrivenDesign.superClassEntity.AggregateRoot {

    @NotNull
    @Length(min = ProducerConstraint.NAME_MIN_LENGTH, max = ProducerConstraint.NAME_MAX_LENGTH)
    private String name;

    Producer(String name) {
        setName(name);
    }

    private void setName(String name) {
        final var fieldName = "nazwa producenta";
        CommonValidators.validateNotNull(name, fieldName);
        CommonValidators.validateMinLength(name, 3, fieldName);
        this.name = name;
    }

    public ProducerCreated generateProducerCreatedEvent() {
        return ProducerFactory.createdEvent(this);
    }

    public ProducerNameChanged changeName(String newName, Predicate<String> providerExistsById) {
        if (providerExistsById.test(newName))
            throw new IllegalStateException(String.format("Producent  z nazwa: %s już istnieje", name));
        ProducerNameChanged producerNameChanged = new ProducerNameChanged(this.name, newName);
        this.setName(newName);
        return producerNameChanged;
    }

    public ProducerRemoved generateCategoryRemoveEvent() {
        return new ProducerRemoved(super.getId(), this.name);
    }

    public ProducerSnap getSnap() {
        return new ProducerSnap(super.getId(), this.name);
    }
}
