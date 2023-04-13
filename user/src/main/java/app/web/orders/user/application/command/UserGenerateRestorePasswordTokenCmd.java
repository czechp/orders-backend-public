package app.web.orders.user.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public
class UserGenerateRestorePasswordTokenCmd {
    private final String email;
}
