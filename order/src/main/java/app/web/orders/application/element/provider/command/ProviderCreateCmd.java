package app.web.orders.application.element.provider.command;

import app.web.orders.domain.element.provider.ProviderConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProviderCreateCmd {
    @Length(min = ProviderConstraint.NAME_MIN_LENGTH, max = ProviderConstraint.NAME_MAX_LENGTH)
    private String name;
}
