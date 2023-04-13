package app.web.orders.application.element.category.handler;

import app.web.orders.application.element.category.command.CategoryRemoveCmd;
import app.web.orders.domain.element.category.Category;
import app.web.orders.domain.element.category.CategoryRepository;
import app.web.orders.domain.element.category.event.CategoryRemoved;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class CategoryRemoveCmdHandler {
    private final CategoryRepository categoryRepository;

    public CategoryRemoved removeProvider(CategoryRemoveCmd categoryRemoveCmd) {
        Category categoryToRemove = categoryRepository.findByIdOrException(categoryRemoveCmd.getProviderId());
        CategoryRemoved categoryRemoved = categoryToRemove.generateCategoryRemoveEvent();
        categoryRepository.delete(categoryToRemove);
        return categoryRemoved;
    }
}
