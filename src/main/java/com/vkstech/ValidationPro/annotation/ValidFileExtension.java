package com.vkstech.ValidationPro.annotation;

import com.vkstech.ValidationPro.validator.ValidFileExtensionValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Validates that a file name or path string ends with one of the allowed file extensions.
 *
 * <p>Supports case-insensitive validation of file types like .jpg, .png, .pdf, etc.</p>
 */
@Documented
@Constraint(validatedBy = ValidFileExtensionValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidFileExtension {

    /**
     * List of valid file extensions (e.g., .jpg, .pdf).
     */
    String[] extensions();

    /**
     * Error message if validation fails.
     */
    String message() default "file extension is not allowed";

    /**
     * Constraint groups.
     */
    Class<?>[] groups() default {};

    /**
     * Custom payloads for clients to assign.
     */
    Class<? extends Payload>[] payload() default {};
}
