package com.vkstech.ValidationPro.annotation;

import com.vkstech.ValidationPro.validator.ContainsSubstringValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Validates that a string field or parameter contains a specified substring.
 * <p>
 * Optional case-insensitive matching is supported.
 * </p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * @ContainsSubstring(value = "admin", ignoreCase = true, message = "Username must contain 'admin'")
 * private String username;
 * }
 * </pre>
 */
@Documented
@Constraint(validatedBy = ContainsSubstringValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ContainsSubstring {

    /**
     * The required substring that must be present within the string.
     *
     * @return the required substring
     */
    String value();

    /**
     * Whether the substring check should ignore case.
     *
     * @return true if the check is case-insensitive, false otherwise
     */
    boolean ignoreCase() default false;

    /**
     * The error message to be shown when validation fails.
     *
     * @return the validation error message
     */
    String message() default "must contain the substring '{value}'";

    /**
     * Allows specification of validation groups.
     *
     * @return the group classes
     */
    Class<?>[] groups() default {};

    /**
     * Can be used to assign custom payload objects to a constraint.
     *
     * @return array of payload classes
     */
    Class<? extends Payload>[] payload() default {};
}
