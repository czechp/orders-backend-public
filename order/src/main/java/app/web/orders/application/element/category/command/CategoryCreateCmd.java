package app.web.orders.application.element.category.command;

import app.web.orders.domain.element.category.CategoryConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CategoryCreateCmd {
    @Length(min = CategoryConstraint.NAME_MIN_LENGTH, max = CategoryConstraint.NAME_MAX_LENGTH)
    private String name;
}
