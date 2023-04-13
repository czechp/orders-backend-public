package app.web.orders.infrastructure.element.provider.rest;

import app.web.orders.application.element.provider.command.ProviderRemoveCmd;
import app.web.orders.application.element.provider.handler.ProviderRemoveCmdHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/providers")
@AllArgsConstructor
class ProviderRemoveController {
    private final ProviderRemoveCmdHandler providerRemoveCmdHandler;

    @DeleteMapping("/{providerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void removeProvider(@PathVariable(name = "providerId") long providerId) {
        providerRemoveCmdHandler.removeProvider(new ProviderRemoveCmd(providerId));
    }
}
