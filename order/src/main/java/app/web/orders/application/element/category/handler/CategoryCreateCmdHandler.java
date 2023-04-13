package app.web.orders.application.element.category.handler;

import app.web.orders.application.element.category.command.CategoryCreateCmd;
import app.web.orders.domain.element.category.Category;
import app.web.orders.domain.element.category.CategoryFactory;
import app.web.orders.domain.element.category.CategoryRepository;
import app.web.orders.domain.element.category.event.CategoryCreated;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class CategoryCreateCmdHandler {
    private final CategoryRepository categoryRepository;

    public CategoryCreated createCategory(CategoryCreateCmd categoryCreateCmd) {
        Category category = CategoryFactory.category(categoryCreateCmd.getName(), categoryRepository::existsByName);
        Category persistedCategory = categoryRepository.save(category);
        return persistedCategory.generateCategoryCreatedEvent();
    }
}
