package app.web.orders.infrastructure.element.element.rest;

import app.web.orders.application.element.element.cmd.ElementUpdateInfoCmd;
import app.web.orders.application.element.element.handler.ElementUpdateInfoCmdHandler;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ElementUpdateInfoController.URL)
@AllArgsConstructor
@Validated
class ElementUpdateInfoController {
    public static final String URL = "/api/elements/info";

    private final ElementUpdateInfoCmdHandler cmdHandler;

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateInfo(@RequestBody @Valid ElementUpdateInfoCmd cmd) {
        cmdHandler.updateInfo(cmd);
    }
}
