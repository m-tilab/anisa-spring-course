package org.example.validation;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchConstraintValidator implements ConstraintValidator<PasswordMatchConstraint, Object> {

    private String password;
    private String passwordMatch;

    @Override
    public void initialize(PasswordMatchConstraint constraintAnnotation) {
        password = constraintAnnotation.password();
        passwordMatch = constraintAnnotation.passwordMatch();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        var passwordValue = new BeanWrapperImpl(value).getPropertyValue(password);
        var passwordMatchValue = new BeanWrapperImpl(value).getPropertyValue(passwordMatch);

        if (passwordValue.equals("") || passwordMatchValue.equals(""))
            return false;

        if (passwordValue != null)
            return passwordValue.equals(passwordMatchValue);

        return passwordMatchValue == null;
    }
}
