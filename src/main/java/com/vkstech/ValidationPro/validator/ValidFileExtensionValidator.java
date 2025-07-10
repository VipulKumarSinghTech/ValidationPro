package com.vkstech.ValidationPro.validator;

import com.vkstech.ValidationPro.annotation.ValidFileExtension;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Validator for {@link ValidFileExtension}.
 * <p>
 * Validates that a string ends with one of the specified file extensions.
 * Comparison is case-insensitive.
 * </p>
 */
public class ValidFileExtensionValidator implements ConstraintValidator<ValidFileExtension, String> {

    private Set<String> validExtensions;

    /**
     * Initializes the allowed extensions from the annotation.
     *
     * @param constraintAnnotation the annotation instance
     */
    @Override
    public void initialize(ValidFileExtension constraintAnnotation) {
        validExtensions = new HashSet<>();
        for (String ext : constraintAnnotation.extensions()) {
            validExtensions.add(ext.toLowerCase(Locale.ROOT));
        }
    }

    /**
     * Validates that the input string ends with one of the allowed extensions.
     *
     * @param value   the string to validate (file name or path)
     * @param context the constraint validator context
     * @return true if valid or null, false otherwise
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;

        String lower = value.toLowerCase(Locale.ROOT);
        return validExtensions.stream().anyMatch(lower::endsWith);
    }
}
