package app.web.orders.infrastructure.order.order.rest;

import app.web.orders.application.order.order.cmd.OrderOrderPositionCmd;
import app.web.orders.application.order.order.handler.OrderOrderPositionCmdHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(OrderOrderPositionController.URL)
@AllArgsConstructor
class OrderOrderPositionController {
    public static final String URL = "/api/orders/order-position";
    private final OrderOrderPositionCmdHandler handler;

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void orderPosition(@RequestBody OrderOrderPositionCmd cmd) {
        handler.handle(cmd);
    }
}
