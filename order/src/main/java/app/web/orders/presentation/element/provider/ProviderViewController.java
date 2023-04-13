package app.web.orders.presentation.element.provider;

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
@RequestMapping("/api/providers")
@AllArgsConstructor
class ProviderViewController {
    private final ProviderViewRepository providerViewRepository;

    @GetMapping("/{providerId}")
    ProviderView findById(@PathVariable(name = "providerId") long providerId) {
        return providerViewRepository.findViewById(providerId)
                .orElseThrow(() -> new ElementNotFoundException(String.format("Dostawca z id: %s nie istnieje", providerId)));
    }

    @GetMapping()
    List<ProviderView> findAll(@SortDefault(sort = "name", direction = Sort.Direction.ASC) Sort sort) {
        return providerViewRepository.findViewBy(sort);
    }
}
