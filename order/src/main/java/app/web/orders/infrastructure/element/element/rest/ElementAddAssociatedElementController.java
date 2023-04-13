package app.web.orders.infrastructure.element.element.rest;

import app.web.orders.application.element.element.cmd.ElementAddAssociatedElementCmd;
import app.web.orders.application.element.element.handler.ElementAddAssociatedElementCmdHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ElementAddAssociatedElementController.URL)
@AllArgsConstructor
class ElementAddAssociatedElementController {
    public static final String URL = "/api/elements/associated-elements";

    private final ElementAddAssociatedElementCmdHandler handler;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    void addAssociatedElements(@RequestBody ElementAddAssociatedElementCmd command) {
        handler.addAssociatedElement(command);
    }
}
