package com.vkstech.ValidationPro.annotation;

import com.vkstech.ValidationPro.validator.NotInValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Validates that the value of a string, number, or enum field is not in a specified list of disallowed values.
 */
@Documented
@Constraint(validatedBy = NotInValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotIn {

    /**
     * List of disallowed values.
     *
     * @return the disallowed string values
     */
    String[] value();

    /**
     * Whether the check should ignore case (only for string fields).
     *
     * @return true if the comparison should ignore case, false otherwise
     */
    boolean ignoreCase() default false;

    /**
     * The error message to return when validation fails.
     *
     * @return the validation error message
     */
    String message() default "must not be in the disallowed list";

    /**
     * Allows grouping of constraints.
     */
    Class<?>[] groups() default {};

    /**
     * Can be used to assign custom payload objects to a constraint.
     */
    Class<? extends Payload>[] payload() default {};
}
