package bg.technologies.carshop.service;

public interface EmailService {

    void sendRegistrationEmail(
            String userEmail,
            String userName,
            String activationCode
    );
}
