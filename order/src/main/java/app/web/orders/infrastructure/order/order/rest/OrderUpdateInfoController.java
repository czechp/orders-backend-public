package app.web.orders.infrastructure.order.order.rest;

import app.web.orders.application.order.order.cmd.OrderUpdateInfoCmd;
import app.web.orders.application.order.order.handler.OrderUpdateInfoCmdHandler;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(OrderUpdateInfoController.URL)
@Validated
@AllArgsConstructor
class OrderUpdateInfoController {
    public static final String URL = "/api/orders/info";
    private final OrderUpdateInfoCmdHandler handler;
    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateInfo(@RequestBody @Valid OrderUpdateInfoCmd command){
        handler.updateInfo(command);
    }
}
