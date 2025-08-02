package com.vkstech.ValidationPro.annotation;

import com.vkstech.ValidationPro.validator.ValidEnumValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Custom validation annotation to ensure a field's value is one of the constants
 * defined in a specified {@link Enum} type.
 *
 * <p>This annotation is typically used on {@code String} fields or parameters that are
 * meant to map to known enum constants.</p>
 *
 * <p>Supports optional case-insensitive comparison for string values using the {@code ignoreCase} flag.</p>
 *
 * @see jakarta.validation.ConstraintValidator
 * @see ValidEnumValidator
 */
@Documented
@Constraint(validatedBy = ValidEnumValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEnum {

    /**
     * Specifies the {@link Enum} class whose constants should be considered valid values.
     *
     * @return the enum class to validate against
     */
    Class<? extends Enum<?>> enumClass();

    /**
     * Indicates whether string comparisons should ignore case when matching enum constants.
     *
     * @return true if case should be ignored; false otherwise
     */
    boolean ignoreCase() default false;

    /**
     * The validation failure message to be returned.
     *
     * @return the error message
     */
    String message() default "must be any of enum {enumClass}";

    /**
     * Validation groups for categorizing constraints.
     *
     * @return array of group classes
     */
    Class<?>[] groups() default {};

    /**
     * Payload for clients to associate metadata with a constraint.
     *
     * @return array of payload classes
     */
    Class<? extends Payload>[] payload() default {};
}
