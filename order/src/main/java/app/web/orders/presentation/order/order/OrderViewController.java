package app.web.orders.presentation.order.order;

import app.web.orders.domain.order.order.OrderState;
import app.web.orders.domain.order.order.PositionStatus;
import app.web.orders.exception.order.OrderExceptions;
import app.web.orders.facade.user.UserFacade;
import app.web.orders.facade.user.UserSnap;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(OrderViewController.URL)
@AllArgsConstructor
class OrderViewController {
    public static final String URL = "/api/orders";
    private final OrderViewRepository orderViewRepository;
    private final PositionDetailsViewRepository positionDetailsViewRepository;
    private final UserFacade userFacade;

    @GetMapping
    List<OrderView> findAll(
            @RequestParam(name = "state") OrderState orderState,
            @SortDefault(sort = "id", direction = Sort.Direction.ASC) Sort sort) {
        return orderViewRepository.findViewByOrderState(orderState, sort);
    }

    @GetMapping("/{orderId}")
    OrderView findById(@PathVariable(name = "orderId") long orderId) {
        return orderViewRepository.findViewById(orderId)
                .orElseThrow(() -> OrderExceptions.notFoundException(orderId));
    }

    @GetMapping("/user")
    List<OrderView> findByCurrentUserAndOrderState(
            @RequestParam(name = "state") OrderState orderState,
            @SortDefault(value = "id", direction = Sort.Direction.ASC) Sort sort
    ) {
        String currentUser = userFacade.currentUser()
                .map(UserSnap::getUsername)
                .orElseThrow(() -> new IllegalStateException("Nie wykryto użytkownika"));
        return orderViewRepository.findByOwnerAndOrderState(currentUser, orderState, sort);
    }

    @GetMapping("/positions/ordered")
    List<PositionDetailsView> findPositionsWithDetails(
            @SortDefault(sort = "id", direction = Sort.Direction.DESC) Sort sort,
            @RequestParam(name = "pattern") Optional<String> pattern) {
        return pattern
                .map(ptr -> positionDetailsViewRepository.filterPositionsByPattern(ptr, PositionStatus.ORDERED, sort))
                .orElse(positionDetailsViewRepository.findByPositionStatus(PositionStatus.ORDERED, sort));
    }
}
