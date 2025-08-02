package com.vkstech.ValidationPro.validator;

import com.vkstech.ValidationPro.annotation.ValidEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

/**
 * Validator for the {@link ValidEnum} annotation.
 *
 * <p>Validates that a given {@code String} value matches one of the names
 * of the constants defined in the specified {@link Enum} type.</p>
 *
 * <p>This validator supports case-sensitive or case-insensitive comparisons,
 * depending on the {@code ignoreCase} flag configured in the annotation.</p>
 *
 * <p>If the input value is {@code null}, it is considered valid. Use {@code @NotNull}
 * in conjunction if nulls should be rejected.</p>
 *
 * @see ValidEnum
 */
public class ValidEnumValidator implements ConstraintValidator<ValidEnum, String> {

    private Class<? extends Enum<?>> enumClass;
    private boolean ignoreCase;

    /**
     * Initializes the validator by capturing the enum class and
     * configuration options from the annotation instance.
     *
     * @param annotation the annotation instance containing configuration
     */
    @Override
    public void initialize(ValidEnum annotation) {
        this.enumClass = annotation.enumClass();
        this.ignoreCase = annotation.ignoreCase();
    }

    /**
     * Validates whether the given {@code String} value matches any of the enum constant names.
     *
     * @param value   the value to validate
     * @param context the constraint validation context
     * @return {@code true} if the value is {@code null} or matches an enum constant; {@code false} otherwise
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;

        Enum<?>[] enumConstants = enumClass.getEnumConstants();
        return Arrays.stream(enumConstants)
                .map(Enum::name)
                .anyMatch(e -> ignoreCase ? e.equalsIgnoreCase(value) : e.equals(value));
    }
}
