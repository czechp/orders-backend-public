package app.web.orders.infrastructure.element.element.rest;

import app.web.orders.application.element.element.handler.ElementUpdateCategoryCmdHandler;
import app.web.orders.application.element.element.cmd.ElementUpdateCategoryCmd;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ElementUpdateCategoryController.URL)
@AllArgsConstructor
class ElementUpdateCategoryController {
    public static final String URL = "/api/elements/category";

    private final ElementUpdateCategoryCmdHandler elementUpdateCategoryCmdHandler;

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateProvider(@RequestBody ElementUpdateCategoryCmd command) {
        elementUpdateCategoryCmdHandler.updateCategory(command);
    }
}
