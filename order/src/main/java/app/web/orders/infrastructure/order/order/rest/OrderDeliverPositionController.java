package app.web.orders.infrastructure.order.order.rest;

import app.web.orders.application.order.order.cmd.OrderDeliverPositionCmd;
import app.web.orders.application.order.order.handler.OrderDeliverPositionCmdHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(OrderDeliverPositionController.URL)
@AllArgsConstructor
class OrderDeliverPositionController {
    public static final String URL = "/api/orders/deliver-position";
    private final OrderDeliverPositionCmdHandler handler;
    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deliverPosition(@RequestBody OrderDeliverPositionCmd command) {
        handler.handle(command);
    }
}
