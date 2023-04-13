package app.web.orders.infrastructure.order.order.rest;

import app.web.orders.application.order.order.cmd.OrderDetermineInternalIdCmd;
import app.web.orders.application.order.order.handler.OrderDetermineInternalIdCmdHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(OrderDetermineInternalIdController.URL)
@AllArgsConstructor
class OrderDetermineInternalIdController {
    public final static String URL = "/api/orders/internal-id";
    private final OrderDetermineInternalIdCmdHandler handler;

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void determineInternalId(@RequestBody OrderDetermineInternalIdCmd command) {
        handler.handle(command);
    }
}
