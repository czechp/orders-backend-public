package app.web.orders.user.application.command;

import app.web.orders.user.domain.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public
class UserAssignRoleCmd {
    private final long userId;
    private final UserRole userRole;
}
