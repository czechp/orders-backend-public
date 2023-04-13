package app.web.orders.presentation.element.provider;

import app.web.orders.domain.element.provider.Provider;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
interface ProviderViewRepository extends Repository<Provider, Long> {
    Optional<ProviderView> findViewById(long id);

    List<ProviderView> findViewBy(Sort sort);
}
