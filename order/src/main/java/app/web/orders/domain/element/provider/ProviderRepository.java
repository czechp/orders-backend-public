package app.web.orders.domain.element.provider;

import app.web.orders.exception.ElementNotFoundException;
import org.springframework.data.repository.CrudRepository;

public interface ProviderRepository extends CrudRepository<Provider, Long> {
    boolean existsByName(String name);

    default Provider findByIdOrException(long id) {
        return this.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(String.format("Dostawca z id: %s nie istnieje", id)));
    }
}
