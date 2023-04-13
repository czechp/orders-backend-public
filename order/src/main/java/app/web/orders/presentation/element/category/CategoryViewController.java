package app.web.orders.presentation.element.category;

import app.web.orders.exception.ElementNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
class CategoryViewController {
    private final CategoryViewRepository categoryViewRepository;

    @GetMapping("/{categoryId}")
    CategoryView findById(@PathVariable(name = "categoryId") long categoryId) {
        return categoryViewRepository.findViewById(categoryId)
                .orElseThrow(() -> new ElementNotFoundException(String.format("Kategoria z id: %s nie istnieje", categoryId)));
    }

    @GetMapping()
    List<CategoryView> findAll(@SortDefault(sort = "name", direction = Sort.Direction.ASC) Sort sort) {
        return categoryViewRepository.findViewBy(sort);
    }
}
