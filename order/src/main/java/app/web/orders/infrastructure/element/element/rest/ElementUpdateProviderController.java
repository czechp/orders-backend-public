package app.web.orders.infrastructure.element.element.rest;

import app.web.orders.application.element.element.handler.ElementUpdateProviderCmdHandler;
import app.web.orders.application.element.element.cmd.ElementUpdateProviderCmd;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ElementUpdateProviderController.URL)
@AllArgsConstructor
class ElementUpdateProviderController {
    public static final String URL = "/api/elements/provider";

    private final ElementUpdateProviderCmdHandler elementUpdateProviderCmdHandler;

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateProvider(@RequestBody ElementUpdateProviderCmd command) {
        elementUpdateProviderCmdHandler.updateProvider(command);
    }
}
