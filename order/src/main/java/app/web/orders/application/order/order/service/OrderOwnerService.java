package app.web.orders.application.order.order.service;

import app.web.orders.domain.order.order.OrderSnap;
import app.web.orders.exception.order.OrderExceptions;
import app.web.orders.facade.user.UserFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderOwnerService {
    private final UserFacade userFacade;

    public void currentUserIsOwnerOrException(OrderSnap orderSnap) {
        String currentUser = userFacade.currentUser()
                .orElseThrow(() -> new IllegalStateException("You are not logged"))
                .getUsername();
        if (!currentUser.equals(orderSnap.getOwner()))
            throw OrderExceptions.userIsNotOwnerOfOrder(currentUser, orderSnap.getId());

    }
}
