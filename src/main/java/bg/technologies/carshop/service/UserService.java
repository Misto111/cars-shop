package bg.technologies.carshop.service;

import bg.technologies.carshop.model.dto.UserRegistrationDTO;
import org.springframework.security.core.Authentication;

public interface UserService {

    void registerUser(UserRegistrationDTO userRegistrationDTO);

    void createUserIfNotExist(String email, String names);

    Authentication login(String email);

}
