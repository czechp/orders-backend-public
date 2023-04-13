package app.web.orders.application.element.element.cmd;

import app.web.orders.domain.element.element.ElementData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Getter
public
class ElementCreateCmd {
    private long producerId;
    private long categoryId;
    private long providerId;
    @Length(min = ElementData.Info.NAME_MIN_LENGTH, max = ElementData.Info.NAME_MAX_LENGTH)
    private String name;
    @Length(max = ElementData.Info.DESCRIPTION_MAX_LENGTH)
    private String description;
    @Length(min = ElementData.Info.URL_MIN_LENGTH, max = ElementData.Info.URL_MAX_LENGTH)
    private String url;
    @Length(min = ElementData.Info.SERIAL_NUMBER_MIN_LENGTH, max = ElementData.Info.SERIAL_NUMBER_MAX_LENGTH)
    private String serialNumber;


}
