package app.web.orders.application.element.element.cmd;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ElementRemoveAssociatedElementCmd {
    private long elementId;
    private long elementIdToRemove;
}
