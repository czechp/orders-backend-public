package app.web.orders.infrastructure.element.category.rest;

import app.web.orders.application.element.category.command.CategoryChangeNameCmd;
import app.web.orders.application.element.category.handler.CategoryChangeNameCmdHandler;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories/name")
@AllArgsConstructor
@Validated
class CategoryChangeNameController {
    private final CategoryChangeNameCmdHandler categoryChangeNameCmdHandler;

    @PatchMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void changeName(@RequestBody @Valid CategoryChangeNameCmd categoryChangeNameCmd) {
        categoryChangeNameCmdHandler.changeName(categoryChangeNameCmd);
    }
}
