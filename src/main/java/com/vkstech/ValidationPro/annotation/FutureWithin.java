package com.vkstech.ValidationPro.annotation;

import com.vkstech.ValidationPro.validator.FutureWithinValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Validates that a {@link java.time.temporal.Temporal} date/time field
 * is in the future, but not more than the specified number of days ahead.
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * @FutureWithin(days = 30, message = "Date must be within 30 days from now")
 * private LocalDate appointmentDate;
 * }
 * </pre>
 */
@Documented
@Constraint(validatedBy = FutureWithinValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FutureWithin {

    /**
     * Maximum number of days in the future allowed.
     *
     * @return the number of days ahead from now
     */
    int days();

    /**
     * The error message returned when validation fails.
     */
    String message() default "must be within {days} days in the future";

    /**
     * Allows grouping of constraints.
     */
    Class<?>[] groups() default {};

    /**
     * Can be used to assign custom payload objects to a constraint.
     */
    Class<? extends Payload>[] payload() default {};
}
