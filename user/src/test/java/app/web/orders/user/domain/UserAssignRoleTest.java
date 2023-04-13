package app.web.orders.user.domain;

import app.web.orders.event.user.UserRoleAssigned;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserAssignRoleTest {
    @Test
    @DisplayName("User.assignRole() - ok")
    void assignRoleTest() {
        //given
        final UserRole newRole = UserRole.ADMIN;
        User user = User.builder()
                .withUserInfo(new UserInfo("Some username", "Some password", "SomeEmail@gmail.com", UserRole.USER))
                .build();
        //when
        UserRoleAssigned userRoleAssigned = user.assignRole(newRole);
        //then
        assertEquals(newRole.toString(), userRoleAssigned.getNewRole());
    }
}