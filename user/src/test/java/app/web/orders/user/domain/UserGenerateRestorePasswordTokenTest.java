package app.web.orders.user.domain;

import app.web.orders.event.user.UserRestorePasswordTokenGenerated;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserGenerateRestorePasswordTokenTest {

    @Test
    @DisplayName("User.generateRestorePasswordToken - ok")
    void generateRestorePasswordToken() {
        //given
        User user = User.builder().withUserRestorePassword(new UserRestorePassword())
                .build();
        //when
        UserRestorePasswordTokenGenerated userRestorePasswordTokenGenerated = user.generateRestorePasswordToken();
        //then
        assertEquals(user.getUserRestorePassword().getRestorePasswordToken(), userRestorePasswordTokenGenerated.getRestoreToken());
    }
}