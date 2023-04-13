package app.web.orders.infrastructure.order.order.rest;

import app.web.orders.application.order.order.cmd.OrderChangePositionQuantityCmd;
import app.web.orders.application.order.order.handler.OrderChangePositionQuantityCmdHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(OrderChangePositionQuantityController.URL)
@AllArgsConstructor
class OrderChangePositionQuantityController {
    public static final String URL = "/api/orders/position/quantity";
    private final OrderChangePositionQuantityCmdHandler handler;
    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updatePositionQuantity(@RequestBody OrderChangePositionQuantityCmd command){
        handler.handle(command);
    }
}
