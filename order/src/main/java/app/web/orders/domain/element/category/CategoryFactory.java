package app.web.orders.domain.element.category;

import app.web.orders.domain.element.category.event.CategoryCreated;

import java.util.function.Predicate;

public class CategoryFactory {
    public static Category category(String name, Predicate<String> providerExistsById) {
        if (providerExistsById.test(name))
            throw new IllegalStateException(String.format("Kategoria z nazwa: %s już istnieje", name));
        return new Category(name);
    }

    static CategoryCreated createdEvent(Category category) {
        return new CategoryCreated(category.getId(), category.getName());
    }
}
