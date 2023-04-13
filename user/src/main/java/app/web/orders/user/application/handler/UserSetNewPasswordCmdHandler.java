package app.web.orders.user.application.handler;

import app.web.orders.event.user.UserNewPasswordSet;
import app.web.orders.exception.ElementNotFoundException;
import app.web.orders.user.application.command.UserSetNewPasswordCmd;
import app.web.orders.user.domain.User;
import app.web.orders.user.domain.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public
class UserSetNewPasswordCmdHandler {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserNewPasswordSet setNewPassword(UserSetNewPasswordCmd userSetNewPasswordCmd) {
        User user = userRepository.findByRestorePasswordToken(userSetNewPasswordCmd.getToken())
                .orElseThrow(() -> new ElementNotFoundException("Nieprawidłowy token"));
        UserNewPasswordSet userNewPasswordSet = user.setNewPassword(
                userSetNewPasswordCmd.getToken(),
                userSetNewPasswordCmd.getNewPassword(),
                passwordEncoder);
        userRepository.save(user);
        return userNewPasswordSet;
    }
}
