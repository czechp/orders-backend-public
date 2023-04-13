package app.web.orders.domain.element.element;

import app.web.orders.domain.element.category.CategorySnap;
import app.web.orders.domain.element.provider.ProviderSnap;
import app.web.orders.domain.element.producer.ProducerSnap;

public class ElementFactory {


    static ElementCategory elementCategory(CategorySnap categorySnap) {
        return new ElementCategory(categorySnap.getId(), categorySnap.getName());
    }

    static ElementProducer elementProducer(ProducerSnap producerSnap) {
        return new ElementProducer(producerSnap.getId(), producerSnap.getName());
    }

    static ElementProvider elementProvider(ProviderSnap providerSnap) {
        return new ElementProvider(providerSnap.getId(), providerSnap.getName());
    }

    private static ElementInfo elementInfo(String name, String description, String url, String serialNumber) {
        return new ElementInfo(name, description, url, serialNumber);
    }

    public static Element element(String name,
                                  String description,
                                  String serialNumber,
                                  String url,
                                  ProducerSnap producerSnap,
                                  CategorySnap categorySnap,
                                  ProviderSnap providerSnap) {
        ElementInfo elementInfo = ElementFactory.elementInfo(name, description, url, serialNumber);
        ElementProvider elementProvider = ElementFactory.elementProvider(providerSnap);
        ElementProducer elementProducer = ElementFactory.elementProducer(producerSnap);
        ElementCategory elementCategory = ElementFactory.elementCategory(categorySnap);
        return new ElementBasicImpl(elementInfo, elementProvider, elementProducer, elementCategory);
    }
}
