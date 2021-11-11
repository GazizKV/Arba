package ru.serafim.web.validation;

import ru.serafim.web.dto.SignUpForm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NamesValidator implements ConstraintValidator<NotSameNames, SignUpForm> {

    @Override
    public boolean isValid(SignUpForm object, ConstraintValidatorContext context) {
        return !object.getFirstName().equals(object.getLastName());
    }
}
