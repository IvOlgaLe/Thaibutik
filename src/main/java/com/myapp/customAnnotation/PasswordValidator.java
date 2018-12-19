package com.myapp.customAnnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {

/*  - Password must contain at least one capital letter
    - Password must contain at least one number
    - Password must contain at least one of the following characters: !, @, #, $, %, ^, &, *  */
    public static final Pattern VALID_PASSWORD_REGEX = Pattern
            .compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*/])");

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_PASSWORD_REGEX.matcher(emailStr);
        return matcher.find();
    }

    @Override
    public void initialize(PasswordConstraint arg0) {
    }

    @Override
    public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
        return (validate(arg0));
    }
}
