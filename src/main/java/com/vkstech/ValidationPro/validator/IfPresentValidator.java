package com.vkstech.ValidationPro.validator;

import com.vkstech.ValidationPro.annotation.IfPresent;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Validator for {@link IfPresent}.
 * <p>
 * This is a no-op validator that returns {@code true} as long as
 * the field is null or present.
 * It defers actual validation to other annotations on the field.
 * </p>
 */
public class IfPresentValidator implements ConstraintValidator<IfPresent, Object> {

    /**
     * Returns {@code true} for all values.
     * Null values are allowed and bypass inner constraints.
     * Non-null values will be validated by any other annotations present.
     *
     * @param value   the field value to validate
     * @param context the constraint validator context
     * @return true (always), since this annotation never fails on its own
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return true; // Let other constraints handle actual validation if value is non-null
    }
}

