package app.web.orders.infrastructure.order.order.rest;

import app.web.orders.application.order.order.cmd.OrderCreateCmd;
import app.web.orders.application.order.order.handler.OrderCreateCmdHandler;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(OrderCreateController.URL)
@Validated
@AllArgsConstructor
class OrderCreateController {
    public static final String URL = "/api/orders";
    private final OrderCreateCmdHandler orderCreateCmdHandler;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createOrder(@RequestBody @Valid OrderCreateCmd orderCreateCmd) {
        orderCreateCmdHandler.createOrder(orderCreateCmd);
    }
}
