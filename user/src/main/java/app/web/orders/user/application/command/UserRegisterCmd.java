package app.web.orders.user.application.command;

import app.web.orders.user.domain.UserConstraints;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor
public class UserRegisterCmd {
    @Length(min = UserConstraints.USERNAME_MIN_LENGTH)
    private String username;
    @Email
    private String email;
    @Length(min = UserConstraints.PASSWORD_MIN_LENGTH)
    private String password;

    public UserRegisterCmd(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
