package com.vkstech.ValidationPro.annotation;

import com.vkstech.ValidationPro.validator.NoHtmlTagsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Validates that a string does not contain HTML or XML tags.
 *
 * <p>Any input containing elements like {@code <tag>} or {@code </tag>} will be considered invalid.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * @NoHtmlTags
 * private String userComment;
 * }
 * </pre>
 */
@Documented
@Constraint(validatedBy = NoHtmlTagsValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NoHtmlTags {

    /**
     * Error message when validation fails.
     */
    String message() default "must not contain HTML or XML tags";

    /**
     * Constraint groups.
     */
    Class<?>[] groups() default {};

    /**
     * Custom payload for clients to assign.
     */
    Class<? extends Payload>[] payload() default {};
}
