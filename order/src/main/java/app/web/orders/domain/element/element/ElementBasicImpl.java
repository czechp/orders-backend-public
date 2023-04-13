package app.web.orders.domain.element.element;

import app.web.orders.domain.element.category.CategorySnap;
import app.web.orders.domain.element.element.event.*;
import app.web.orders.domain.element.producer.ProducerSnap;
import app.web.orders.domain.element.provider.ProviderSnap;
import app.web.orders.domainDrivenDesign.annotation.AggregateRoot;
import app.web.orders.exception.element.ElementExceptions;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;


@AggregateRoot
@Entity
@Table(name = ElementData.BASIC_TABLE_NAME)
@NoArgsConstructor
@Builder(setterPrefix = "with", access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@DynamicUpdate
@DynamicInsert
class ElementBasicImpl extends app.web.orders.domainDrivenDesign.superClassEntity.AggregateRoot implements Element {
    @Embedded
    private ElementProvider elementProvider;
    @Embedded
    private ElementProducer elementProducer;
    @Embedded
    private ElementCategory elementCategory;
    @Embedded
    private ElementInfo elementInfo;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = ElementData.ASSOCIATED_ELEMENTS_TABLE, joinColumns = {@JoinColumn(name = "elementId")})
    @Column(name = "associatedElementId")
    private Set<Long> associatedElements = new HashSet<>();

    ElementBasicImpl(ElementInfo elementInfo, ElementProvider elementProvider, ElementProducer elementProducer, ElementCategory elementCategory) {
        this.elementInfo = elementInfo;
        this.elementProvider = elementProvider;
        this.elementProducer = elementProducer;
        this.elementCategory = elementCategory;
    }

    public ElementCreated createEvent() {
        return new ElementCreated(this.getId(),
                this.elementInfo.getName(),
                this.elementInfo.getDescription(),
                this.elementInfo.getSerialNumber(),
                this.elementInfo.getUrl());
    }

    @Override
    public ElementInfoUpdated updateInfo(String name, String description, String serialNumber, String url, Predicate<String> elementExistsWithSerialNumber) {
        boolean serialNumbersAreDifferent = !this.elementInfo.getSerialNumber().equals(serialNumber);
        boolean serialNumberIsNotUniqueness = elementExistsWithSerialNumber.test(serialNumber);

        if (serialNumbersAreDifferent && serialNumberIsNotUniqueness)
            throw ElementExceptions.existsWithSameSerialNumber(serialNumber);

        ElementInfoUpdated elementInfoUpdated = new ElementInfoUpdated(super.getId());
        elementInfoUpdated.setOldData(this.elementInfo.getName(),
                elementInfo.getDescription(),
                elementInfo.getSerialNumber(),
                elementInfo.getUrl());
        elementInfoUpdated.setNewData(name, description, serialNumber, url);

        this.elementInfo = new ElementInfo(name, description, url, serialNumber);
        return elementInfoUpdated;
    }

    @Override
    public ElementProviderUpdated updateProvider(ProviderSnap providerSnap) {
        ElementProviderUpdated elementProviderUpdated = new ElementProviderUpdated(getId(),
                this.elementProvider.getProviderId(),
                providerSnap.getId(),
                this.elementProvider.getProvider(),
                providerSnap.getName());
        this.elementProvider = ElementFactory.elementProvider(providerSnap);
        return elementProviderUpdated;
    }

    @Override
    public ElementCategoryUpdated updateCategory(CategorySnap categorySnap) {
        ElementCategoryUpdated elementCategoryUpdated = new ElementCategoryUpdated(getId(),
                elementCategory.getCategoryId(),
                categorySnap.getId(),
                elementCategory.getCategory(),
                categorySnap.getName()
        );
        this.elementCategory = ElementFactory.elementCategory(categorySnap);

        return elementCategoryUpdated;
    }

    @Override
    public ElementProducerUpdated updateProducer(ProducerSnap producerSnap) {
        ElementProducerUpdated elementProducerUpdated = new ElementProducerUpdated(getId(),
                elementProducer.getProducerId(),
                producerSnap.getId(),
                elementProducer.getProducer(),
                producerSnap.getName());

        elementProducer = ElementFactory.elementProducer(producerSnap);

        return elementProducerUpdated;
    }


    @Override
    public ElementAssociatedElementAdded addAssociatedElement(Element element) {
        ElementBasicImpl candidate = (ElementBasicImpl) element;
        long candidateId = candidate.getId();
        boolean candidateIsEntity = super.getUuid().equals(candidate.getUuid());
        if (candidateIsEntity)
            throw new IllegalStateException("Nie można powiązać elementu samego z sobą");
        associatedElements.add(candidateId);
        return new ElementAssociatedElementAdded(super.getId(), candidateId);
    }

    @Override
    public ElementAssociatedElementRemoved removeAssociatedElement(Element element) {
        long elementIdToRemove = ((ElementBasicImpl) element).getId();
        boolean elementsContainId = associatedElements.contains(elementIdToRemove);
        if (!elementsContainId)
            throw new IllegalStateException(String.format("Elemment nie zawiera powiązanego elementu z id: %d", elementIdToRemove));
        associatedElements.remove(elementIdToRemove);
        return new ElementAssociatedElementRemoved(getId(), elementIdToRemove);
    }
}
