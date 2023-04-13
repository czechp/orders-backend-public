package app.web.orders.infrastructure.element.producer.rest;

import app.web.orders.application.element.producer.command.ProducerCreateCmd;
import app.web.orders.application.element.producer.handler.ProducerCreateCmdHandler;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/producers")
@AllArgsConstructor
@Validated
class ProducerCreateController {
    private final ProducerCreateCmdHandler producerCreateCmdHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createCategory(@RequestBody @Valid ProducerCreateCmd producerCreateCmd) {
        producerCreateCmdHandler.createCategory(producerCreateCmd);
    }
}
