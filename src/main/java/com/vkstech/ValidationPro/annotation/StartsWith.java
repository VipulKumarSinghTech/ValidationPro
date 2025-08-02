package com.vkstech.ValidationPro.annotation;

import com.vkstech.ValidationPro.validator.StartsWithValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Validates that a string field or parameter starts with a specified prefix.
 * <p>
 * Optionally supports case-insensitive matching.
 * </p>
 */
@Documented
@Constraint(validatedBy = StartsWithValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface StartsWith {

    /**
     * The required prefix that the string must start with.
     *
     * @return the required prefix
     */
    String prefix();

    /**
     * Whether the prefix check should ignore case.
     *
     * @return true if the check is case-insensitive, false otherwise
     */
    boolean ignoreCase() default false;

    /**
     * The error message to be shown when validation fails.
     *
     * @return the validation error message
     */
    String message() default "must start with '{prefix}'";

    /**
     * Allows grouping of constraints.
     */
    Class<?>[] groups() default {};

    /**
     * Can be used to assign custom payload objects to a constraint.
     */
    Class<? extends Payload>[] payload() default {};
}
