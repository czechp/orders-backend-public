package app.web.orders.infrastructure.order.order.rest;

import app.web.orders.application.order.order.cmd.OrderCloseCmd;
import app.web.orders.application.order.order.handler.OrderCloseCmdHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(OrderCloseController.URL)
@AllArgsConstructor
class OrderCloseController {
    public static final String URL = "/api/orders/close";
    private final OrderCloseCmdHandler handler;

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void closeOrder(@RequestBody OrderCloseCmd command) {
        handler.handle(command);
    }

}
