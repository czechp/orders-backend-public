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
@Getter(AccessLevel.PACKAGE)
class ElementCategory {
    private long categoryId;
    private String category;

    ElementCategory(long categoryId, String category) {
        setCategoryId(categoryId);
        setCategory(category);
    }

    private void setCategory(String category) {
        CommonValidators.validateNotNull(category, ElementData.Category.CATEGORY);
        CommonValidators.validateMinLength(category, ElementData.Category.CATEGORY_MIN_LENGTH, ElementData.Category.CATEGORY);
        CommonValidators.validateMaxLength(category, ElementData.Category.CATEGORY_MAX_LENGTH, ElementData.Category.CATEGORY);
        this.category = category;
    }

    private void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElementCategory that = (ElementCategory) o;
        return categoryId == that.categoryId && category.equals(that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, category);
    }
}
