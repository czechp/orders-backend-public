package app.web.orders.user.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public
class UserRemoveCmd {
    private final long userId;
}
