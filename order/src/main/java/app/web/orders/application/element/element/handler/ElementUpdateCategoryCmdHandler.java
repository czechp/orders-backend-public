package app.web.orders.application.element.element.handler;

import app.web.orders.application.element.element.cmd.ElementUpdateCategoryCmd;
import app.web.orders.domain.element.element.Element;
import app.web.orders.domain.element.element.ElementRepository;
import app.web.orders.domain.element.category.Category;
import app.web.orders.domain.element.category.CategoryRepository;
import app.web.orders.domain.element.element.event.ElementCategoryUpdated;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ElementUpdateCategoryCmdHandler {
    private final ElementRepository elementRepository;
    private final CategoryRepository categoryRepository;

    public ElementCategoryUpdated updateCategory(ElementUpdateCategoryCmd command) {
        Element element = elementRepository.findByIdOrThrowException(command.getElementId());
        Category category = categoryRepository.findByIdOrException(command.getCategoryId());
        ElementCategoryUpdated elementCategoryUpdated = element.updateCategory(category.getSnap());
        return elementCategoryUpdated;
    }
}
