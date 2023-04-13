package app.web.orders.event.user;

import app.web.orders.domainDrivenDesign.annotation.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
@DomainEvent
@Getter
@AllArgsConstructor
public class UserNewPasswordSet {
    private final String newPasswordHash;
}
