package app.web.orders.event.user;

import app.web.orders.domainDrivenDesign.annotation.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;

@DomainEvent
@Getter
@AllArgsConstructor
public class UserRegistered extends app.web.orders.domainDrivenDesign.superClass.DomainEvent {
    private long id;
    private String username;
    private String email;
    private String confirmationToken;


}
