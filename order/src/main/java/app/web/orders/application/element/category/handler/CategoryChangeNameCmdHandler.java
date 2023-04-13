package app.web.orders.application.element.category.handler;

import app.web.orders.application.element.category.command.CategoryChangeNameCmd;
import app.web.orders.domain.element.category.Category;
import app.web.orders.domain.element.category.CategoryRepository;
import app.web.orders.domain.element.category.event.CategoryNameChanged;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
@Transactional
public class CategoryChangeNameCmdHandler {
    private final CategoryRepository categoryRepository;

    public CategoryNameChanged changeName(CategoryChangeNameCmd changeNameCmd) {
        Category category = categoryRepository.findByIdOrException(changeNameCmd.getCategoryId());
        CategoryNameChanged categoryNameChanged = category.changeName(changeNameCmd.getNewName(), categoryRepository::existsByName);
        return categoryNameChanged;
    }
}
