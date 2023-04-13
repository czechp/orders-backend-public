package app.web.orders.infrastructure.order.order.rest;

import app.web.orders.application.order.order.cmd.OrderReleaseToExecutionCmd;
import app.web.orders.application.order.order.handler.OrderReleaseToExecutionCmdHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(OrderReleaseToExecutionController.URL)
@AllArgsConstructor
class OrderReleaseToExecutionController {
    public static final String URL = "/api/orders/execution-release";
    private final OrderReleaseToExecutionCmdHandler handler;
    @PatchMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void releaseToExecution(@PathVariable(name = "orderId") long orderId) {
        handler.handle(new OrderReleaseToExecutionCmd(orderId));
    }
}
