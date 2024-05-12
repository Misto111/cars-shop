package bg.technologies.carshop.service;

import bg.technologies.carshop.model.events.UserRegisteredEvent;

public interface UserActivationService {

    void userRegistered(UserRegisteredEvent event);

    void cleanUpObsoleteActivationLinks();

    String createActivationCode(String userEmail);
}
