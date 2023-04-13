package app.web.orders.domain.element.element;

import app.web.orders.domain.element.category.CategorySnap;
import app.web.orders.domain.element.element.event.*;
import app.web.orders.domain.element.producer.ProducerSnap;
import app.web.orders.domain.element.provider.ProviderSnap;

import java.util.function.Predicate;

public interface Element {
    ElementCreated createEvent();

    ElementInfoUpdated updateInfo(String name,
                                  String description,
                                  String serialNumber,
                                  String url,
                                  Predicate<String> serialNumberIsUnique);

    ElementProviderUpdated updateProvider(ProviderSnap providerSnap);

    ElementCategoryUpdated updateCategory(CategorySnap categorySnap);

    ElementProducerUpdated updateProducer(ProducerSnap producerSnap);

    ElementAssociatedElementAdded addAssociatedElement(Element element);

    ElementAssociatedElementRemoved removeAssociatedElement(Element element);
}
