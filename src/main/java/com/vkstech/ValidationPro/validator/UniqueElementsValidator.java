package com.vkstech.ValidationPro.validator;

import com.vkstech.ValidationPro.annotation.UniqueElements;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Validator for {@link UniqueElements}.
 * <p>Checks whether a collection contains only unique elements.</p>
 */
public class UniqueElementsValidator implements ConstraintValidator<UniqueElements, Collection<?>> {

    /**
     * Validates that all elements in the collection are unique.
     *
     * @param value   the collection to validate
     * @param context the validation context
     * @return true if all elements are unique or the collection is null; false otherwise
     */
    @Override
    public boolean isValid(Collection<?> value, ConstraintValidatorContext context) {
        if (value == null) return true;

        Set<Object> seen = new HashSet<>();
        for (Object element : value) {
            if (!seen.add(element)) {
                return false; // Duplicate found
            }
        }
        return true;
    }
}

