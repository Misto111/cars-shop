package bg.technologies.carshop.model.dto;

import bg.technologies.carshop.model.validation.FieldMatch;
import bg.technologies.carshop.model.validation.UniqueUserEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
@FieldMatch(  //моя валидация
       first = "password",             //матчва password с confirmPassword
        second = "confirmPassword",
        message = "Password should match."
)
public record UserRegistrationDTO(@NotEmpty String firstName,
                                 @NotEmpty String lastName,
                                  @NotNull @Email @UniqueUserEmail String email,
                                  String password,
                                  String confirmPassword) {

    public String fullName() {
        return firstName + " " + lastName;
    }
}


