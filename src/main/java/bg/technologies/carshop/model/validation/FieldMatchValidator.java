package bg.technologies.carshop.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.context.annotation.Bean;

import java.util.Objects;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {


    private String first;

    private String second;

    private String message;

    @Override
    public void initialize(FieldMatch constraintAnnotation) { //тук ще дойдат полетата от UserRegistrationDTO, които съм въвел, преди да се стартира валидацията
       this.first = constraintAnnotation.first();
       this.second = constraintAnnotation.second();
       this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        BeanWrapper beanWrapper = PropertyAccessorFactory. //този клас ни дава възможност с помощта на рефлекшън да достъпваме различни полета в този биин
                forBeanPropertyAccess(value);

        Object firstProperty = beanWrapper.getPropertyValue(this.first);
        Object secondProperty = beanWrapper.getPropertyValue(this.second);

        boolean isValid =  Objects.equals(firstProperty, secondProperty);

        if (!isValid) {
            context
                    .buildConstraintViolationWithTemplate(message)//искаме да билднем констраин валидейшъна с този message
                    .addPropertyNode(second)//казваме, че второто поле не е добре
                    .addConstraintViolation()//добавяме, че имаме проблем с този контрейнт
                    .disableDefaultConstraintViolation();// и дизейбълнем дефолтния констреинт валидейшън, който е на ниво тип
        }

        return  isValid;
    }
}
