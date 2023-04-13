package app.web.orders.infrastructure.order.order.rest;

import app.web.orders.application.order.order.cmd.OrderAddPositionCmd;
import app.web.orders.application.order.order.handler.OrderAddPositionCmdHandler;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(OrderAddPositionController.URL)
@AllArgsConstructor
class OrderAddPositionController {
    public static final String URL = "/api/orders/position";
    private final OrderAddPositionCmdHandler orderAddPositionCmdHandler;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    void addPosition( @RequestBody OrderAddPositionCmd command) {
        orderAddPositionCmdHandler.addPosition(command);
    }
}
