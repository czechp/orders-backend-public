package app.web.orders.user.infrastructure.email;

import app.web.orders.user.application.service.UserEmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Profile({"production"})
@AllArgsConstructor
@Slf4j
class UserEmailServiceImpl implements UserEmailService {
    private static final String SOURCE_ADDRESS = "zamowienia-automatycy@bispol.pl";

    private final JavaMailSender javaMailSender;

    private final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    @Override
    public void sendConfirmationTokenToUser(String emailAddress, String confirmationToken) {
        String messageContent = "<h2>Zamówienia automatycy - token potwierdzający</h2>\n" +
                "Twój token to: <h3><i>" +
                confirmationToken +
                "</i></h3>\n" +
                messageFooter();
                sendMsgTo(emailAddress, "Potwierdzenie adresu email - zamówienia automatycy", messageContent);
    }

    @Override
    public void sendRestorePasswordToken(String emailAddress, String restorePasswordToken) {
        String messageContent = "<h2>Zamówienia automatycy - odzyskiwanie hasła</h2>\n" +
                "Twój token do odzyskania hasła to: <h3><i>" +
                restorePasswordToken +
                "</i></h3>\n" +
                messageFooter();
        sendMsgTo(emailAddress, "Odzyskiwanie hasła - zamówienia automatycy", messageContent);
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
