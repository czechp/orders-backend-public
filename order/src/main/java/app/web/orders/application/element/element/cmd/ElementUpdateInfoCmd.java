package app.web.orders.application.element.element.cmd;

import app.web.orders.domain.element.element.ElementData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Getter
@Setter
public class ElementUpdateInfoCmd {
    private long elementId;
    @Length(min = ElementData.Info.NAME_MIN_LENGTH, max = ElementData.Info.NAME_MAX_LENGTH)
    private String name;

    @Length(max = ElementData.Info.DESCRIPTION_MAX_LENGTH)
    private String description;

    @Length(min = ElementData.Info.SERIAL_NUMBER_MIN_LENGTH, max = ElementData.Info.SERIAL_NUMBER_MAX_LENGTH)
    private String serialNumber;

    @Length(min = ElementData.Info.URL_MIN_LENGTH, max = ElementData.Info.URL_MAX_LENGTH)
    private String url;
}
