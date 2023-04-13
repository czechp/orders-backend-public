package app.web.orders.domain.element.element;

import app.web.orders.exception.element.ElementExceptions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElementRepository extends JpaRepository<ElementBasicImpl, Long> {

    boolean existsByElementInfoSerialNumber(String serialNumber);

    default Element saveElement(Element element) {
        return this.save((ElementBasicImpl) element);
    }

    default Element findByIdOrThrowException(long elementId) {
        return findById(elementId)
                .orElseThrow(() -> ElementExceptions.notFound(elementId));
    }

    List<Element> findAllByAssociatedElements(long elementId);

    default void deleteElement(Element element) {
        delete((ElementBasicImpl) element);
    }
}
