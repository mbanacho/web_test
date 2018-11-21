package pl.mbanacho.corpo.service.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PeselValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PeselConstraint {

    String message() default "Invalid pesel number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
