package bg.technologies.carshop.web;

import bg.technologies.carshop.model.dto.UserRegistrationDTO;
import bg.technologies.carshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/users")
@Controller
public class UserRegistrationController {


    private final UserService userService;

    public UserRegistrationController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }
    @PostMapping("/register")
    public String register(UserRegistrationDTO userRegistrationDTO) {

        this.userService.registerUser(userRegistrationDTO);

        return "redirect:/";
    }
}
