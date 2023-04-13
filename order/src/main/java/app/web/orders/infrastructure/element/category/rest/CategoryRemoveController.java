package app.web.orders.infrastructure.element.category.rest;

import app.web.orders.application.element.category.handler.CategoryRemoveCmdHandler;
import app.web.orders.application.element.category.command.CategoryRemoveCmd;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
class CategoryRemoveController {
    private final CategoryRemoveCmdHandler providerRemoveCmdHandler;

    @DeleteMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void removeProvider(@PathVariable(name = "categoryId") long categoryId) {
        providerRemoveCmdHandler.removeProvider(new CategoryRemoveCmd(categoryId));
    }
}
