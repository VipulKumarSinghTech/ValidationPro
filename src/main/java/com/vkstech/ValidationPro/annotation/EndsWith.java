package com.vkstech.ValidationPro.annotation;

import com.vkstech.ValidationPro.validator.EndsWithValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Validates that a string field or parameter ends with a specified suffix.
 * <p>
 * Supports optional case-insensitive matching.
 * </p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * @EndsWith(suffix = ".com", ignoreCase = true, message = "Email must end with '.com'")
 * private String email;
 * }
 * </pre>
 */
@Documented
@Constraint(validatedBy = EndsWithValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface EndsWith {

    /**
     * The required suffix that the string must end with.
     *
     * @return the required suffix
     */
    String suffix();

    /**
     * Whether the suffix check should ignore case.
     *
     * @return true if the check is case-insensitive, false otherwise
     */
    boolean ignoreCase() default false;

    /**
     * The error message to be returned when validation fails.
     *
     * @return the validation error message
     */
    String message() default "must end with '{suffix}'";

    /**
     * Allows specification of validation groups.
     *
     * @return the group classes
     */
    Class<?>[] groups() default {};

    /**
     * Can be used by clients to assign custom payload objects to a constraint.
     *
     * @return array of payload classes
     */
    Class<? extends Payload>[] payload() default {};
}

