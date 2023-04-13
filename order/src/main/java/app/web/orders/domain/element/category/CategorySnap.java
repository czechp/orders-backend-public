package app.web.orders.domain.element.category;

import app.web.orders.domainDrivenDesign.annotation.ValueObject;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@ValueObject
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class CategorySnap {
    private final long id;
    private final String name;
}
