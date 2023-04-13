package app.web.orders.user.application.handler;

import app.web.orders.event.user.UserRestorePasswordTokenGenerated;
import app.web.orders.exception.ElementNotFoundException;
import app.web.orders.user.application.command.UserGenerateRestorePasswordTokenCmd;
import app.web.orders.user.application.service.UserEmailService;
import app.web.orders.user.domain.User;
import app.web.orders.user.domain.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UserGenerateRestorePasswordTokenCmdHandler {
    private final UserRepository userRepository;
    private final UserEmailService userEmailService;

    public UserRestorePasswordTokenGenerated generateRestorePasswordToken(UserGenerateRestorePasswordTokenCmd cmd) {
        User user = userRepository.findByEmail(cmd.getEmail())
                .orElseThrow(() -> new ElementNotFoundException(String.format("Użytkownik z emailem %s nie istnieje", cmd.getEmail())));
        UserRestorePasswordTokenGenerated userRestorePasswordTokenGenerated = user.generateRestorePasswordToken();
        userEmailService.sendRestorePasswordToken(cmd.getEmail(), userRestorePasswordTokenGenerated.getRestoreToken());
        userRepository.save(user);
        return userRestorePasswordTokenGenerated;
    }
}
