package com.vkstech.ValidationPro.validator;

import com.vkstech.ValidationPro.annotation.FieldsMatch;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;

/**
 * Validator for the {@link FieldsMatch} annotation.
 * <p>
 * Compares two fields in a class for equality using reflection.
 * </p>
 */
public class FieldsMatchValidator implements ConstraintValidator<FieldsMatch, Object> {

    private String fieldName;
    private String fieldMatchName;

    /**
     * Initializes the validator with annotation values.
     *
     * @param annotation the {@link FieldsMatch} annotation instance
     */
    @Override
    public void initialize(FieldsMatch annotation) {
        this.fieldName = annotation.field();
        this.fieldMatchName = annotation.fieldMatch();
    }

    /**
     * Validates that the two specified fields in the object are equal.
     *
     * @param object  the object to validate
     * @param context the constraint validator context
     * @return true if the fields are equal (or both null), false otherwise
     */
    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            Field fieldMatch = object.getClass().getDeclaredField(fieldMatchName);

            field.setAccessible(true);
            fieldMatch.setAccessible(true);

            Object value1 = field.get(object);
            Object value2 = fieldMatch.get(object);

            return (value1 == null && value2 == null) || (value1 != null && value1.equals(value2));
        } catch (Exception e) {
            // Consider logging this in real-world scenarios
            return false;
        }
    }
}

