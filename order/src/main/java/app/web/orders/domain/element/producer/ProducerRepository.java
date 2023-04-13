package app.web.orders.domain.element.producer;

import app.web.orders.exception.ElementNotFoundException;
import org.springframework.data.repository.CrudRepository;

public interface ProducerRepository extends CrudRepository<Producer, Long> {
    boolean existsByName(String name);

    default Producer findByIdOrException(long id) {
        return this.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(String.format("Producent z id: %s nie istnieje", id)));
    }
}
