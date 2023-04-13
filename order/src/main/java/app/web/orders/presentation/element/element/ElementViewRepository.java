package app.web.orders.presentation.element.element;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
interface ElementViewRepository extends PagingAndSortingRepository<ElementView, Long> {
    <T> Optional<T> findViewById(long id, Class<T> type);

    <T> List<T> findViewBy(Sort sort);

    @Query("select elementView from ElementView elementView where " +
            "upper(elementView.name) like concat('%',upper(:pattern),'%') or " +
            "upper(elementView.serialNumber) like concat('%',upper(:pattern),'%') or " +
            "upper(elementView.description) like concat('%',upper(:pattern),'%') or " +
            "upper(elementView.producer) like concat('%',upper(:pattern),'%')")
    List<ElementView> filterFieldsByPattern(String pattern, Sort sort);

    @Transactional(readOnly = true)
    default List<ElementView> findAllAssociatedElements(long elementId) {
        Set<Long> associatedElementsIds = findViewById(elementId, ElementView.class)
                .map(ElementView::getAssociatedElements)
                .orElse(new HashSet<Long>());
        return findAllViewFromSet(associatedElementsIds);
    }

    @Query("select element from ElementView element where element.id in :ids")
    List<ElementView> findAllViewFromSet(Set<Long> ids);
}
