package app.web.orders.domain.element.element;

import app.web.orders.domainDrivenDesign.annotation.ValueObject;
import app.web.orders.validator.CommonValidators;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@ValueObject
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
class ElementProducer {
    private long producerId;
    private String producer;

    ElementProducer(long producerId, String producer) {
        setProducerId(producerId);
        setProducer(producer);
    }

    private void setProducer(String producer) {
        CommonValidators.validateNotNull(producer, ElementData.Producer.PRODUCER);
        CommonValidators.validateMinLength(producer, ElementData.Producer.PRODUCER_MIN_LENGTH, ElementData.Producer.PRODUCER);
        CommonValidators.validateMaxLength(producer, ElementData.Producer.PRODUCER_MAX_LENGTH, ElementData.Producer.PRODUCER);
        this.producer = producer;
    }

    private void setProducerId(long producerId) {
        this.producerId = producerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElementProducer that = (ElementProducer) o;
        return producerId == that.producerId && producer.equals(that.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producerId, producer);
    }
}
