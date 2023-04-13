package app.web.orders.application.element.producer.command;

import app.web.orders.domain.element.category.CategoryConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProducerChangeNameCmd {
    private long producerId;
    @Length(min = CategoryConstraint.NAME_MIN_LENGTH, max = CategoryConstraint.NAME_MAX_LENGTH)
    private String newName;
}
