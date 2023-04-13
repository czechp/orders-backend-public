package app.web.orders.infrastructure.order.order.email;

import app.web.orders.application.order.order.service.OrderEmailService;
import app.web.orders.domain.order.order.OrderSnap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"development", "test"})
@Slf4j
class OrderEmailServiceDevelopmentImpl implements OrderEmailService {
    @Override
    public void orderReleasedToExecution(OrderSnap orderSnap) {
        log.info("Email about releasing order with name {} to execution sent", orderSnap.getName());
    }
}
