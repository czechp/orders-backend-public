package app.web.orders.infrastructure.element.category.rest;

import app.web.orders.application.element.category.handler.CategoryCreateCmdHandler;
import app.web.orders.application.element.category.command.CategoryCreateCmd;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
@Validated
class CategoryCreateController {
    private final CategoryCreateCmdHandler categoryChangeNameCmdHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createCategory(@RequestBody @Valid CategoryCreateCmd categoryCreateCmd) {
        categoryChangeNameCmdHandler.createCategory(categoryCreateCmd);
    }
}
