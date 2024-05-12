package bg.technologies.carshop.service.impl;

import bg.technologies.carshop.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailServiceImpl implements EmailService {

    private final TemplateEngine templateEngine;
    private final JavaMailSender javaMailSender;
    private final String carshopEmail;

    public EmailServiceImpl(
            TemplateEngine templateEngine,
            JavaMailSender javaMailSender,
            @Value("${mail.carshop}") String carshopEmail) {
        this.templateEngine = templateEngine;
        this.javaMailSender = javaMailSender;
        this.carshopEmail = carshopEmail;
    }

@Override
    public void sendRegistrationEmail(String userEmail, String userName, String activationCode)  {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();   //wrapper на съобщение, което ще изпратя по email

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        try {

            mimeMessageHelper.setTo(userEmail);
            mimeMessageHelper.setFrom(carshopEmail);
            mimeMessageHelper.setReplyTo(carshopEmail);
            mimeMessageHelper.setSubject("Welcome to carshop!");
            mimeMessageHelper.setText(generateRegistrationEmailBody(userName, activationCode), true);

           javaMailSender.send(mimeMessageHelper.getMimeMessage());

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateRegistrationEmailBody(String userName, String activationCode) {

        Context context = new Context();
        context.setVariable("username", userName);
        context.setVariable("activationCode", activationCode);

        return templateEngine.process("email/registration-email", context);
    }
}
