package bg.technologies.carshop.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.Year;

public class YearNotinInTheFutureValidator implements ConstraintValidator<YearNotInTheFuture, Number> {
    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        } else {

            int currentYear = Year.now().getValue();

            return value.intValue() <= currentYear;
        }
    }
}
