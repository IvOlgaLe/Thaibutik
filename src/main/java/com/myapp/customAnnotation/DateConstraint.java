package com.myapp.customAnnotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateValidator.class)
@Target( {ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateConstraint {
    String message() default "Invalid date format: the proper format “MM/DD/YYYY”";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
