package bg.technologies.carshop.model.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//достъпна е повреме на компилация
@Target(ElementType.FIELD)//казваме къде може да се приложи самата анотация(на ниво поле)
@Constraint(validatedBy = UniqueUserEmailValidator.class) //казваме кой ще е класът, който ще валидира полето, което е анотирано с тази анотация
public @interface UniqueUserEmail {


    String message() default "The user email should be unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
