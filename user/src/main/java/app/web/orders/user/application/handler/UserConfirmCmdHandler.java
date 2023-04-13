package app.web.orders.user.application.handler;

import app.web.orders.event.user.UserConfirmed;
import app.web.orders.user.application.command.UserConfirmCmd;
import app.web.orders.user.domain.User;
import app.web.orders.user.domain.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UserConfirmCmdHandler {
    private final UserRepository userRepository;

    public UserConfirmed confirmUser(UserConfirmCmd userConfirmCmd) {
        User user = userRepository.findByConfirmationToken(userConfirmCmd.getConfirmationToken())
                .orElseThrow(() -> new IllegalStateException(String
                        .format("Nie znaleziono użytkownika z takim tokenem: %s", userConfirmCmd.getConfirmationToken())));
        UserConfirmed userConfirmed = user.confirmUser(userConfirmCmd.getConfirmationToken());
        userRepository.save(user);
        return userConfirmed;
    }
}
