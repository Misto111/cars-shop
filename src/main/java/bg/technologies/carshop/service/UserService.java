package bg.technologies.carshop.service;

import bg.technologies.carshop.model.dto.UserLoginDTO;
import bg.technologies.carshop.model.dto.UserRegistrationDTO;

public interface UserService {

    void registerUser(UserRegistrationDTO userRegistrationDTO);

    boolean loginUser(UserLoginDTO userLoginDTO);

    void logoutUser();


}
