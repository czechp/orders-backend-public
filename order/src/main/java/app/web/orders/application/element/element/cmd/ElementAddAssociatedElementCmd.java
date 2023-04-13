package app.web.orders.application.element.element.cmd;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ElementAddAssociatedElementCmd {
    private long elementId;
    private long elementIdToAdd;
}
