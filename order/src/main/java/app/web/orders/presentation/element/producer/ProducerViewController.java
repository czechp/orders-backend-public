package app.web.orders.presentation.element.producer;

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
@RequestMapping("/api/producers")
@AllArgsConstructor
class ProducerViewController {
    private final ProducerViewRepository producerViewRepository;

    @GetMapping("/{producerId}")
    ProducerView findById(@PathVariable(name = "producerId") long categoryId) {
        return producerViewRepository.findViewById(categoryId)
                .orElseThrow(() -> new ElementNotFoundException(String.format("Producer z id: %s nie istnieje", categoryId)));
    }

    @GetMapping()
    List<ProducerView> findAll(@SortDefault(sort = "name", direction = Sort.Direction.ASC) Sort sort) {
        return producerViewRepository.findViewBy(sort);
    }
}
