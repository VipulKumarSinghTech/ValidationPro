package com.vkstech.ValidationPro.validator;

import com.vkstech.ValidationPro.annotation.ValidEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class ValidEnumValidator implements ConstraintValidator<ValidEnum, String> {

    private Class<? extends Enum<?>> enumClass;
    private boolean ignoreCase;

    @Override
    public void initialize(ValidEnum annotation) {
        this.enumClass = annotation.enumClass();
        this.ignoreCase = annotation.ignoreCase();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;

        Enum<?>[] enumConstants = enumClass.getEnumConstants();
        return Arrays.stream(enumConstants)
                .map(Enum::name)
                .anyMatch(e -> ignoreCase ? e.equalsIgnoreCase(value) : e.equals(value));
    }
}
