package com.vkstech.ValidationPro.validator;

import com.vkstech.ValidationPro.annotation.EndsWith;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Validator for the {@link EndsWith} annotation.
 * <p>
 * Ensures that the input string ends with the specified suffix,
 * with optional case-insensitive comparison.
 * </p>
 */
public class EndsWithValidator implements ConstraintValidator<EndsWith, String> {

    private String suffix;
    private boolean ignoreCase;

    /**
     * Initializes the validator with values from the {@link EndsWith} annotation.
     *
     * @param constraintAnnotation the annotation instance containing suffix and flags
     */
    @Override
    public void initialize(EndsWith constraintAnnotation) {
        this.suffix = constraintAnnotation.suffix();
        this.ignoreCase = constraintAnnotation.ignoreCase();
    }

    /**
     * Validates whether the input string ends with the specified suffix.
     *
     * @param value   the string value to validate
     * @param context the constraint validator context
     * @return true if the string ends with the suffix (or is null), false otherwise
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true; // Allow nulls; combine with @NotNull if needed

        return ignoreCase
                ? value.toLowerCase().endsWith(suffix.toLowerCase())
                : value.endsWith(suffix);
    }
}

