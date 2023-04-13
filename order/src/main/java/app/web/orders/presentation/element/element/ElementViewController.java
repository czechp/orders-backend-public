package app.web.orders.presentation.element.element;

import app.web.orders.exception.element.ElementExceptions;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping(ElementViewController.URL)
@AllArgsConstructor
class ElementViewController {
    public static final String URL = "/api/elements";
    private ElementViewRepository elementViewRepository;

    @GetMapping
    List<ElementView> findBy(@RequestParam(name = "pattern") Optional<String> pattern,
                             @SortDefault(value = "id", direction = Sort.Direction.ASC) Sort sort) {
        return pattern
                .map(p -> elementViewRepository.filterFieldsByPattern(p, sort))
                .orElseGet(() -> elementViewRepository.findViewBy(sort));
    }

    @GetMapping("/{elementId}")
    ElementView findById(@PathVariable(name = "elementId") long elementId) {
        return elementViewRepository.findViewById(elementId, ElementView.class)
                .orElseThrow(() -> ElementExceptions.notFound(elementId));
    }

    @GetMapping("/associated-elements/{elementId}")
    List<ElementView> findAllAssociatedElements(@PathVariable(name = "elementId") long elementId) {
        return elementViewRepository.findAllAssociatedElements(elementId);
    }

}
