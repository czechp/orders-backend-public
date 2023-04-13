package app.web.orders.infrastructure.element.producer.rest;

import app.web.orders.application.element.producer.command.ProducerChangeNameCmd;
import app.web.orders.application.element.producer.handler.ProducerChangeNameCmdHandler;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/producers/name")
@AllArgsConstructor
@Validated
class ProducerChangeNameController {
    private final ProducerChangeNameCmdHandler producerChangeNameCmdHandler;

    @PatchMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void changeName(@RequestBody @Valid ProducerChangeNameCmd producerChangeNameCmd) {
        producerChangeNameCmdHandler.changeName(producerChangeNameCmd);
    }
}
