package app.web.orders.infrastructure.element.element.rest;

import app.web.orders.application.element.element.cmd.ElementCreateCmd;
import app.web.orders.application.element.element.handler.ElementCreateCmdHandler;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ElementCreateController.URL)
@Validated
@AllArgsConstructor
class ElementCreateController {
    public static final String URL = "/api/elements";
    private final ElementCreateCmdHandler elementCreateCmdHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createElement(@RequestBody @Valid ElementCreateCmd elementCreateCmd) {
        elementCreateCmdHandler.createElement(elementCreateCmd);
    }

}
