package app.web.orders.facade.user;

import java.util.List;
import java.util.Optional;

public interface UserFacade {
    Optional<UserSnap> currentUser();

    List<String> managementEmails();
}
