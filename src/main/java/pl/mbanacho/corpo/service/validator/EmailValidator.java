package pl.mbanacho.corpo.service.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {

    @Override
    public boolean isValid(String emailField,ConstraintValidatorContext cxt) {
        return emailField != null && emailField.matches("[\\w]+@{1}[\\w]+[.]{1}[\\w]{1,3}");
    }
}