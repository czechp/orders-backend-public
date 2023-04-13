package app.web.orders.user.application.handler;

import app.web.orders.event.user.UserRemoved;
import app.web.orders.user.application.command.UserRemoveCmd;
import app.web.orders.user.domain.User;
import app.web.orders.user.domain.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UserRemoveCmdHandler {
    private final UserRepository userRepository;

    public UserRemoved removeUser(UserRemoveCmd userRemoveCmd) {
        User userToRemove = userRepository.findByIdOrThrowException(userRemoveCmd.getUserId());
        userRepository.remove(userToRemove);
        return userToRemove.userRemovedEvent();
    }
}
