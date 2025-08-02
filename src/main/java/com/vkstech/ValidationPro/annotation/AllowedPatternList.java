package com.vkstech.ValidationPro.annotation;

import com.vkstech.ValidationPro.validator.AllowedPatternListValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Validates that a string matches at least one of the provided regular expression patterns.
 *
 * <p>Useful when input can conform to multiple formats, like different phone number styles or ID patterns.</p>
 */
@Documented
@Constraint(validatedBy = AllowedPatternListValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface AllowedPatternList {

    /**
     * List of allowed regex patterns.
     */
    String[] patterns();

    /**
     * Error message to return if input does not match any pattern.
     */
    String message() default "does not match any of the allowed patterns";

    /**
     * Groups for conditional validation.
     */
    Class<?>[] groups() default {};

    /**
     * Payload for clients to use.
     */
    Class<? extends Payload>[] payload() default {};
}

