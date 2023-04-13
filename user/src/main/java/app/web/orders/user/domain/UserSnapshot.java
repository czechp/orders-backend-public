package app.web.orders.user.domain;

import app.web.orders.domainDrivenDesign.superClass.DomainSnapshot;

import java.time.LocalDateTime;

public interface UserSnapshot extends DomainSnapshot {
    String getUsername();

    String getEmail();

    String getPassword();

    String getConfirmToken();

    LocalDateTime getConfirmTokenExpiredAt();

    boolean isConfirmed();

    UserRole getUserRole();

    boolean isConfirmedByAdmin();

    String getRestorePasswordToken();

    LocalDateTime getRestorePasswordTokenExpiration();
}
