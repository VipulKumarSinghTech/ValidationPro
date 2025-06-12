package com.vkstech.ValidationPro.validator;

import com.vkstech.ValidationPro.annotation.NotIn;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.HashSet;
import java.util.Set;

/**
 * Validator for the {@link NotIn} annotation.
 * <p>
 * Ensures that the annotated field's value is not in a list of disallowed values.
 * Works with strings and converts other types to string for comparison.
 * </p>
 */
public class NotInValidator implements ConstraintValidator<NotIn, Object> {

    private Set<String> disallowedValues;
    private boolean ignoreCase;

    /**
     * Initializes the validator by reading the disallowed values and settings.
     *
     * @param annotation the {@link NotIn} annotation instance
     */
    @Override
    public void initialize(NotIn annotation) {
        this.ignoreCase = annotation.ignoreCase();
        this.disallowedValues = new HashSet<>();

        for (String val : annotation.value()) {
            disallowedValues.add(ignoreCase ? val.toLowerCase() : val);
        }
    }

    /**
     * Validates that the field's value is not within the disallowed list.
     *
     * @param value   the value to validate
     * @param context the constraint validator context
     * @return true if valid (not in disallowed list), false otherwise
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) return true; // null values are allowed

        String strValue = value.toString();
        return ignoreCase
                ? !disallowedValues.contains(strValue.toLowerCase())
                : !disallowedValues.contains(strValue);
    }
}
