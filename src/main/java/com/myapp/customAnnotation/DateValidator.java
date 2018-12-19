package com.myapp.customAnnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateValidator implements ConstraintValidator<DateConstraint, String> {
    /*       dob: Create an annotation for this member variable to make sure is in the proper format “MM/DD/YYYY”
                and that is not an unreasonable day of birth. Example: 12/23/2023  */
    public static final Pattern VALID_BIRTHDAY_REGEX = Pattern
            .compile("^(((0?[1-9]|1[012])/(0?[1-9]|1\\d|2[0-8])|(0?[13456789]|1[012])/(29|30)|(0?[13578]|1[02])/31)/(19|[2-9]\\d)\\d{2}|0?2/29/((19|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|(([2468][048]|[3579][26])00)))$");

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_BIRTHDAY_REGEX.matcher(emailStr);
        return matcher.find();
    }

    @Override
    public void initialize(DateConstraint dateConstraint) {
        //TODO
    }

    @Override
    public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
        return (validate(arg0));
    }


}
