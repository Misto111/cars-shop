package bg.technologies.carshop.service.impl;

import bg.technologies.carshop.model.dto.UserRegistrationDTO;
import bg.technologies.carshop.model.entity.UserEntity;
import bg.technologies.carshop.model.events.UserRegisteredEvent;
import bg.technologies.carshop.repository.UserRepository;
import bg.technologies.carshop.service.UserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ApplicationEventPublisher appEventPublisher;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           ApplicationEventPublisher appEventPublisher) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.appEventPublisher = appEventPublisher;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {

        userRepository.save(map(userRegistrationDTO));

        appEventPublisher.publishEvent(new UserRegisteredEvent(
                "UserService", userRegistrationDTO.email(),
                userRegistrationDTO.fullName()));
    }


    private  UserEntity map(UserRegistrationDTO userRegistrationDTO) {

        return new UserEntity()
                .setActive(false)
                .setFirstName(userRegistrationDTO.firstName())
                .setLastName(userRegistrationDTO.lastName())
                .setEmail(userRegistrationDTO.email())
                .setPassword(passwordEncoder.encode(userRegistrationDTO.password()));

    }
}
