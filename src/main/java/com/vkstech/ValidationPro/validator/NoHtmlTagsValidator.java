package com.vkstech.ValidationPro.validator;

import com.vkstech.ValidationPro.annotation.NoHtmlTags;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

/**
 * Validator implementation for {@link NoHtmlTags}.
 * <p>
 * Rejects strings containing any HTML or XML-like tags such as {@code <b>}, {@code </div>}, etc.
 * </p>
 */
public class NoHtmlTagsValidator implements ConstraintValidator<NoHtmlTags, String> {

    /**
     * Regex pattern to match any HTML/XML-style tags like <tag>, </tag>, <br/>, etc.
     */
    private static final Pattern HTML_TAG_PATTERN = Pattern.compile("<[^>]+>");

    /**
     * Validates that the input string does not contain HTML tags.
     *
     * @param value   the input string to validate
     * @param context the validation context
     * @return true if no HTML tags found or if input is null, false otherwise
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;
        return !HTML_TAG_PATTERN.matcher(value).find();
    }
}

