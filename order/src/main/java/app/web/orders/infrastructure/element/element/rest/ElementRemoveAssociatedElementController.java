package app.web.orders.infrastructure.element.element.rest;

import app.web.orders.application.element.element.handler.ElementRemoveAssociatedElementCmdHandler;
import app.web.orders.application.element.element.cmd.ElementRemoveAssociatedElementCmd;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ElementRemoveAssociatedElementController.URL)
@AllArgsConstructor
class ElementRemoveAssociatedElementController {
    public static final String URL = "/api/elements/associated-elements";

    private final ElementRemoveAssociatedElementCmdHandler handler;

    @DeleteMapping("/{elementId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void removeAssociatedElement(@PathVariable(name = "elementId") long elementId,
                                 @RequestParam(name = "associatedElementId")long associatedElementId) {
        ElementRemoveAssociatedElementCmd command = new ElementRemoveAssociatedElementCmd(elementId, associatedElementId);
        handler.removeAssociatedElement(command);
    }
}
