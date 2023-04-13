package app.web.orders.presentation.element.category;

import app.web.orders.domain.element.category.Category;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
interface CategoryViewRepository extends Repository<Category, Long> {
    Optional<CategoryView> findViewById(long id);

    List<CategoryView> findViewBy(Sort sort);
}
