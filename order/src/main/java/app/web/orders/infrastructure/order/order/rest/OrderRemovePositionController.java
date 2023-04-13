package app.web.orders.infrastructure.order.order.rest;

import app.web.orders.application.order.order.cmd.OrderRemovePositionCmd;
import app.web.orders.application.order.order.handler.OrderRemovePositionCmdHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(OrderRemovePositionController.URL)
@AllArgsConstructor
class OrderRemovePositionController {
    public static final String URL = "/api/orders/position";

    private final OrderRemovePositionCmdHandler handler;

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void removePosition(@RequestParam(name = "orderId") long orderId, @RequestParam(name = "positionId") long positionId) {
        OrderRemovePositionCmd command = new OrderRemovePositionCmd(orderId, positionId);
        handler.handle(command);
    }
}
