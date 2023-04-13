package app.web.orders.presentation.element.producer;

import app.web.orders.domain.element.producer.Producer;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
interface ProducerViewRepository extends Repository<Producer, Long> {
    Optional<ProducerView> findViewById(long id);

    List<ProducerView> findViewBy(Sort sort);
}
