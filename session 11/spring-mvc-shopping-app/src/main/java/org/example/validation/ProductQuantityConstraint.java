package org.example.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ProductQuantityConstraintValidator.class)
public @interface ProductQuantityConstraint {

    String message() default "Quantity must between 2 and 1000 numbers and must be even";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int lower() default 2;

    int upper() default 1000;
}
