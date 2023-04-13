package app.web.orders.user.application.handler;

import app.web.orders.event.user.UserRoleAssigned;
import app.web.orders.user.application.command.UserAssignRoleCmd;
import app.web.orders.user.domain.User;
import app.web.orders.user.domain.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class UserAssignRoleCmdHandler {
    private final UserRepository userRepository;

    public UserRoleAssigned assignRole(UserAssignRoleCmd userAssignRoleCmd) {
        User user = userRepository.findByIdOrThrowException(userAssignRoleCmd.getUserId());
        UserRoleAssigned userRoleAssigned = user.assignRole(userAssignRoleCmd.getUserRole());
        userRepository.save(user);
        return userRoleAssigned;
    }
}
