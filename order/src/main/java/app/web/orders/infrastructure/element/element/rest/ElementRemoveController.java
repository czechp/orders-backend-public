package app.web.orders.infrastructure.element.element.rest;

import app.web.orders.application.element.element.cmd.ElementRemoveCmd;
import app.web.orders.application.element.element.handler.ElementRemoveCmdHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ElementRemoveController.URL)
@AllArgsConstructor
class ElementRemoveController {
    public static final String URL = "/api/elements";
    private final ElementRemoveCmdHandler handler;

    @DeleteMapping("/{elementId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void removeElement(@PathVariable(name = "elementId")long elementId) {
        handler.removeElement(new ElementRemoveCmd(elementId));
    }
}
