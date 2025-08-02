package com.vkstech.ValidationPro.annotation;

import com.vkstech.ValidationPro.validator.FieldsMatchValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Class-level constraint that validates two fields in the same object
 * are equal (e.g., password and confirmPassword).
 */
@Documented
@Constraint(validatedBy = FieldsMatchValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldsMatch {

    /**
     * The first field to compare.
     *
     * @return the name of the first field
     */
    String field();

    /**
     * The second field to compare.
     *
     * @return the name of the second field
     */
    String fieldMatch();

    /**
     * The error message to return when validation fails.
     *
     * @return the validation error message
     */
    String message() default "Fields do not match";

    /**
     * Allows grouping of constraints.
     *
     * @return validation groups
     */
    Class<?>[] groups() default {};

    /**
     * Can be used by clients to assign custom payload objects to a constraint.
     *
     * @return array of payload classes
     */
    Class<? extends Payload>[] payload() default {};
}
