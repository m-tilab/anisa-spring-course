package org.example.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductQuantityConstraintValidator implements ConstraintValidator<ProductQuantityConstraint, Integer> {

    private int lower;
    private int upper;

    @Override
    public void initialize(ProductQuantityConstraint productQuantityConstraint) {

        lower = productQuantityConstraint.lower();
        upper = productQuantityConstraint.upper();
    }

    @Override
    public boolean isValid(Integer productQuantity, ConstraintValidatorContext constraintValidatorContext) {

        if (productQuantity == null)
            return false;

        if (productQuantity < lower || productQuantity > upper)
            return false;

        if (productQuantity % 2 == 1)
            return false;

        return true;
    }
}
