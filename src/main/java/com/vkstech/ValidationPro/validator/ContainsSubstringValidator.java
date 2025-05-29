package com.vkstech.ValidationPro.validator;

import com.vkstech.ValidationPro.annotation.ContainsSubstring;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Validator for the {@link ContainsSubstring} annotation.
 * <p>
 * Checks whether a given string contains the specified substring,
 * with optional case-insensitive comparison.
 * </p>
 */
public class ContainsSubstringValidator implements ConstraintValidator<ContainsSubstring, String> {

    private String substring;
    private boolean ignoreCase;

    /**
     * Initializes the validator with the values from the {@link ContainsSubstring} annotation.
     *
     * @param constraintAnnotation the annotation instance
     */
    @Override
    public void initialize(ContainsSubstring constraintAnnotation) {
        this.substring = constraintAnnotation.value();
        this.ignoreCase = constraintAnnotation.ignoreCase();
    }

    /**
     * Validates that the given string contains the expected substring.
     *
     * @param value   the string to validate
     * @param context the constraint validator context
     * @return true if the string contains the substring (or is null), false otherwise
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true; // Allow nulls by default

        return ignoreCase
                ? value.toLowerCase().contains(substring.toLowerCase())
                : value.contains(substring);
    }
}

