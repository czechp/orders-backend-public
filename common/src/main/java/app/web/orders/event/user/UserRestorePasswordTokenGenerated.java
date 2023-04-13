package app.web.orders.event.user;

import app.web.orders.domainDrivenDesign.annotation.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;


@DomainEvent
@AllArgsConstructor
@Getter
public class UserRestorePasswordTokenGenerated {
    private final String restoreToken;
}
