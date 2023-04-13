package app.web.orders.infrastructure.order.order.email;

import app.web.orders.application.order.order.service.OrderEmailService;
import app.web.orders.domain.order.order.OrderSnap;
import app.web.orders.facade.user.UserFacade;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Profile({"production"})
@AllArgsConstructor
@Slf4j
class OrderEmailServiceProductionImpl implements OrderEmailService {
    private static final String SOURCE_ADDRESS = "zamowienia-automatycy@bispol.pl";
    private final JavaMailSender javaMailSender;
    private final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private final UserFacade userFacade;

    @Override
    public void orderReleasedToExecution(OrderSnap orderSnap) {
        String msg = createMsg(orderSnap.getName(), orderSnap.getOwner());
        List<String> managementEmails = userFacade.managementEmails();
        managementEmails.forEach(email -> sendMsgTo(email, "Nowe zamówienie do realizacji", msg));

    }

    private String createMsg(String name, String owner) {
        return new StringBuilder()
                .append("<h2>Zamówienia automatycy - wystawiono zamówienie do realizacji </h2>\n")
                .append(String.format("Zamówienie %s stworzone przez %s jest gotowe do realizacji", name, owner))
                .toString();
    }

    private void sendMsgTo(String email, String subject, String content) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setFrom(SOURCE_ADDRESS);
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content, true);

            sendAsync(mimeMessage, email);
        } catch (MessagingException e) {
            log.error("Sending email msg to {} with subject {} failed", email, subject);
        }
    }

    private void sendAsync(MimeMessage mimeMessage, String email) {
        CompletableFuture.runAsync(() -> {
            javaMailSender.send(mimeMessage);
            log.info("Email sent to: {}", email);
        }, executorService);
    }

    private String messageFooter() {
        return "------------------------------------------------------------------------------------------------------------------------------------------------------------<br>" +
                "<i>Wiadomość wygenerowana przez system obsługi zamówień dla działu automatyki - proszę nie odpisywać";
    }
}
