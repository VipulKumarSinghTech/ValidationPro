package com.vkstech.ValidationPro.validator;

import com.vkstech.ValidationPro.annotation.StartsWith;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Validator for {@link StartsWith} annotation.
 * <p>
 * Checks whether the input string starts with the specified prefix,
 * optionally ignoring case.
 * </p>
 */
public class StartsWithValidator implements ConstraintValidator<StartsWith, String> {

    private String prefix;
    private boolean ignoreCase;

    /**
     * Initializes the validator with annotation parameters.
     *
     * @param constraintAnnotation the {@link StartsWith} annotation instance
     */
    @Override
    public void initialize(StartsWith constraintAnnotation) {
        this.prefix = constraintAnnotation.prefix();
        this.ignoreCase = constraintAnnotation.ignoreCase();
    }

    /**
     * Validates that the given string starts with the expected prefix.
     *
     * @param value   the value to validate
     * @param context the constraint validator context
     * @return true if the value starts with the prefix or is null, false otherwise
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true; // null values are considered valid

        return ignoreCase
                ? value.toLowerCase().startsWith(prefix.toLowerCase())
                : value.startsWith(prefix);
    }
}
