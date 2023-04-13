package app.web.orders.user.infrastructure.rest;

import app.web.orders.user.application.command.UserSetNewPasswordCmd;
import app.web.orders.user.application.handler.UserSetNewPasswordCmdHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/set-new-password")
@AllArgsConstructor
class UserSetPasswordController {
    private final UserSetNewPasswordCmdHandler userSetNewPasswordCmdHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void setNewPassword(@RequestBody UserSetNewPasswordCmd userSetNewPasswordCmd){
        userSetNewPasswordCmdHandler.setNewPassword(userSetNewPasswordCmd);
    }
}
