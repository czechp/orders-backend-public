package app.web.orders.domain.element.category;

import app.web.orders.exception.ElementNotFoundException;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    boolean existsByName(String name);

    default Category findByIdOrException(long id) {
        return this.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(String.format("Kateoria z id: %s nie istnieje", id)));
    }
}
