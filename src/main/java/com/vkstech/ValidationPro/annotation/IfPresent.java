package com.vkstech.ValidationPro.annotation;

import com.vkstech.ValidationPro.validator.IfPresentValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Container annotation that enables validation of a field
 * only if the field is not {@code null}.
 *
 * <p>Use this to apply validations like {@code @Pattern}, {@code @Size}, etc.,
 * conditionally when a field is present (i.e., not null).</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * @IfPresent
 * @Pattern(regexp = "\\d{10}", message = "Must be a 10-digit phone number")
 * private String phoneNumber;
 * }
 * </pre>
 */
@Documented
@Constraint(validatedBy = IfPresentValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface IfPresent {

    /**
     * Error message (never shown unless validation fails in internal constraint).
     */
    String message() default "Invalid value";

    /**
     * Allows grouping of constraints.
     */
    Class<?>[] groups() default {};

    /**
     * Can be used by clients to assign custom payload objects to a constraint.
     */
    Class<? extends Payload>[] payload() default {};
}
