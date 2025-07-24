package com.vkstech.ValidationPro.annotation;

import com.vkstech.ValidationPro.validator.UniqueElementsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Validates that all elements in a collection are unique according to {@code equals()}.
 *
 * <p>This annotation applies to {@link java.util.Collection} types like {@link java.util.List} or {@link java.util.Set}.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * @UniqueElements(message = "Tags must be unique")
 * private List<String> tags;
 * }
 * </pre>
 */
@Documented
@Constraint(validatedBy = UniqueElementsValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueElements {

    /**
     * Default error message when validation fails.
     */
    String message() default "collection contains duplicate elements";

    /**
     * Validation groups.
     */
    Class<?>[] groups() default {};

    /**
     * Custom payloads for clients.
     */
    Class<? extends Payload>[] payload() default {};
}

