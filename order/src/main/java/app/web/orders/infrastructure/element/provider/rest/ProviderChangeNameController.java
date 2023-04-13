package app.web.orders.infrastructure.element.provider.rest;

import app.web.orders.application.element.provider.handler.ProviderChangeNameCmdHandler;
import app.web.orders.application.element.provider.command.ProviderChangeNameCmd;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/providers/name")
@AllArgsConstructor
@Validated
class ProviderChangeNameController {
    private final ProviderChangeNameCmdHandler providerChangeNameCmdHandler;

    @PatchMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void changeName(@RequestBody @Valid ProviderChangeNameCmd providerChangeNameCmd) {
        providerChangeNameCmdHandler.changeName(providerChangeNameCmd);
    }
}
