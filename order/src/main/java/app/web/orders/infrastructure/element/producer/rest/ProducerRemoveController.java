package app.web.orders.infrastructure.element.producer.rest;

import app.web.orders.application.element.producer.command.ProducerRemoveCmd;
import app.web.orders.application.element.producer.handler.ProducerRemoveCmdHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/producers")
@AllArgsConstructor
class ProducerRemoveController {
    private final ProducerRemoveCmdHandler producerRemoveCmdHandler;

    @DeleteMapping("/{producerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void removeProvider(@PathVariable(name = "producerId") long producerId) {
        producerRemoveCmdHandler.removeProducer(new ProducerRemoveCmd(producerId));
    }
}
