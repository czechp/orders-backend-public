package app.web.orders.user.application.handler;

import app.web.orders.event.user.UserConfirmedByAdmin;
import app.web.orders.user.application.command.UserConfirmByAdminCmd;
import app.web.orders.user.domain.User;
import app.web.orders.user.domain.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UserConfirmByAdminCmdHandler {
    private final UserRepository userRepository;

    public UserConfirmedByAdmin confirmByAdmin(UserConfirmByAdminCmd userConfirmByAdminCmd) {
        User userToConfirmation = userRepository.findByIdOrThrowException(userConfirmByAdminCmd.getUserId());
        UserConfirmedByAdmin userConfirmedByAdmin = userToConfirmation.confirmUserByAdmin(userConfirmByAdminCmd.isTargetState());
        userRepository.save(userToConfirmation);
        return userConfirmedByAdmin;
    }
}
