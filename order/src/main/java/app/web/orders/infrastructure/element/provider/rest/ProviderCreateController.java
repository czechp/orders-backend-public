package app.web.orders.infrastructure.element.provider.rest;

import app.web.orders.application.element.provider.handler.ProviderCreateCmdHandler;
import app.web.orders.application.element.provider.command.ProviderCreateCmd;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/providers")
@AllArgsConstructor
@Validated
class ProviderCreateController {
    private final ProviderCreateCmdHandler providerCreateCmdHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createProvider(@RequestBody @Valid ProviderCreateCmd providerCreateCmd) {
        providerCreateCmdHandler.createProvider(providerCreateCmd);
    }
}
