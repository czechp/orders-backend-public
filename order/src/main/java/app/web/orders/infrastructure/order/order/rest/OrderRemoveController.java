package app.web.orders.infrastructure.order.order.rest;

import app.web.orders.application.order.order.cmd.OrderRemoveCmd;
import app.web.orders.application.order.order.handler.OrderRemoveCmdHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(OrderRemoveController.URL)
@AllArgsConstructor
class OrderRemoveController {
    public static final String URL = "/api/orders";
    private final OrderRemoveCmdHandler handler;

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void removeOrder(@PathVariable(name = "orderId") long orderId) {
        handler.handle(new OrderRemoveCmd(orderId));
    }
}
