package app.web.orders.application.element.producer.command;

import app.web.orders.domain.element.producer.ProducerConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProducerCreateCmd {
    @Length(min = ProducerConstraint.NAME_MIN_LENGTH, max = ProducerConstraint.NAME_MAX_LENGTH)
    private String name;
}
