package com.vkstech.ValidationPro.validator;

import com.vkstech.ValidationPro.annotation.FutureWithin;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

/**
 * Validator for the {@link FutureWithin} annotation.
 * <p>
 * Validates that a {@link Temporal} value is in the future but not
 * more than a specified number of days from the current time.
 * </p>
 */
public class FutureWithinValidator implements ConstraintValidator<FutureWithin, Temporal> {

    private int maxDays;

    /**
     * Initializes the validator with values from the annotation.
     *
     * @param constraintAnnotation the {@link FutureWithin} annotation
     */
    @Override
    public void initialize(FutureWithin constraintAnnotation) {
        this.maxDays = constraintAnnotation.days();
    }

    /**
     * Validates whether the given temporal value is in the future
     * and within the maximum allowed number of days.
     *
     * @param value   the temporal value to validate
     * @param context the constraint context
     * @return true if valid or null, false otherwise
     */
    @Override
    public boolean isValid(Temporal value, ConstraintValidatorContext context) {
        if (value == null) return true;

        if (value instanceof LocalDate) {
            LocalDate now = LocalDate.now();
            LocalDate date = (LocalDate) value;
            return date.isAfter(now) && ChronoUnit.DAYS.between(now, date) <= maxDays;
        }

        if (value instanceof LocalDateTime) {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime dateTime = (LocalDateTime) value;
            return dateTime.isAfter(now) && ChronoUnit.DAYS.between(now, dateTime) <= maxDays;
        }

        if (value instanceof OffsetDateTime) {
            OffsetDateTime now = OffsetDateTime.now();
            OffsetDateTime offsetDateTime = (OffsetDateTime) value;
            return offsetDateTime.isAfter(now) && ChronoUnit.DAYS.between(now, offsetDateTime) <= maxDays;
        }

        // Unsupported type
        return false;
    }
}


