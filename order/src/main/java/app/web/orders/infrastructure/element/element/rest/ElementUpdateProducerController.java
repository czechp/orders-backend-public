package app.web.orders.infrastructure.element.element.rest;

import app.web.orders.application.element.element.cmd.ElementUpdateProducerCmd;
import app.web.orders.application.element.element.handler.ElementUpdateProducerCmdHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ElementUpdateProducerController.URL)
@AllArgsConstructor
class ElementUpdateProducerController {
    public static final String URL = "/api/elements/producer";

    private final ElementUpdateProducerCmdHandler elementUpdateProducerCmdHandler;

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateProducer(@RequestBody ElementUpdateProducerCmd command) {
        elementUpdateProducerCmdHandler.updateProducer(command);
    }
}
