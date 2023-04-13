package app.web.orders.application.order.order.service;

import app.web.orders.domain.order.order.OrderSnap;

public interface OrderEmailService {
    void orderReleasedToExecution(OrderSnap orderSnap);
}
