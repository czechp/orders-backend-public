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
class ElementProvider {
    private long providerId;
    private String provider;

    ElementProvider(long providerId, String provider) {
        setProviderId(providerId);
        setProvider(provider);
    }

    private void setProvider(String provider) {
        CommonValidators.validateNotNull(provider, ElementData.Provider.PROVIDER);
        CommonValidators.validateMinLength(provider, ElementData.Provider.PROVIDER_MIN_LENGTH, ElementData.Provider.PROVIDER);
        CommonValidators.validateMaxLength(provider, ElementData.Provider.PROVIDER_MAX_LENGTH, ElementData.Provider.PROVIDER);
        this.provider = provider;
    }

    private void setProviderId(long providerId) {
        this.providerId = providerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElementProvider that = (ElementProvider) o;
        return providerId == that.providerId && provider.equals(that.provider);
    }

    @Override
    public int hashCode() {
        return Objects.hash(providerId, provider);
    }
}
