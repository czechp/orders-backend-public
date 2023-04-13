package app.web.orders.domain.element.element;

import app.web.orders.domainDrivenDesign.annotation.ValueObject;
import app.web.orders.validator.CommonValidators;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@ValueObject
@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class ElementInfo {

    private String name;
    private String description;
    private String url;
    private String serialNumber;

    public ElementInfo(String name, String description, String url, String serialNumber) {
        setName(name);
        setDescription(description);
        setUrl(url);
        setSerialNumber(serialNumber);
    }

    private void setSerialNumber(String serialNumber) {
        CommonValidators.validateNotNull(serialNumber, ElementData.Info.SERIAL_NUMBER);
        CommonValidators.validateMinLength(serialNumber, ElementData.Info.SERIAL_NUMBER_MIN_LENGTH, ElementData.Info.SERIAL_NUMBER);
        CommonValidators.validateMaxLength(serialNumber, ElementData.Info.SERIAL_NUMBER_MAX_LENGTH, ElementData.Info.SERIAL_NUMBER);
        this.serialNumber = serialNumber;
    }

    private void setUrl(String url) {
        CommonValidators.validateNotNull(url, ElementData.Info.URL);
        CommonValidators.validateMinLength(url, ElementData.Info.URL_MIN_LENGTH, ElementData.Info.URL);
        CommonValidators.validateMaxLength(url, ElementData.Info.URL_MAX_LENGTH, ElementData.Info.URL);
        this.url = url;
    }

    private void setDescription(String description) {
        CommonValidators.validateNotNull(description, ElementData.Info.DESCRIPTION);
        CommonValidators.validateMinLength(description, ElementData.Info.DESCRIPTION_MIN_LENGTH, ElementData.Info.DESCRIPTION);
        CommonValidators.validateMaxLength(description, ElementData.Info.DESCRIPTION_MAX_LENGTH, ElementData.Info.DESCRIPTION);
        this.description = description;
    }

    private void setName(String name) {
        CommonValidators.validateNotNull(name, ElementData.Info.NAME);
        CommonValidators.validateMinLength(name, ElementData.Info.NAME_MIN_LENGTH, ElementData.Info.NAME);
        CommonValidators.validateMaxLength(name, ElementData.Info.NAME_MAX_LENGTH, ElementData.Info.NAME);
        this.name = name;
    }


}
