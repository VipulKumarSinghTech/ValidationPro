package com.vkstech.ValidationPro.validator;

import com.vkstech.ValidationPro.annotation.AllowedPatternList;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Validator for {@link AllowedPatternList}.
 * <p>
 * Checks that the input string matches at least one of the allowed regular expression patterns.
 * </p>
 */
public class AllowedPatternListValidator implements ConstraintValidator<AllowedPatternList, String> {

    private final List<Pattern> compiledPatterns = new ArrayList<>();

    /**
     * Initializes and compiles the provided regex patterns from the annotation.
     *
     * @param annotation the {@link AllowedPatternList} instance
     */
    @Override
    public void initialize(AllowedPatternList annotation) {
        for (String regex : annotation.patterns()) {
            compiledPatterns.add(Pattern.compile(regex));
        }
    }

    /**
     * Validates that the string matches at least one of the allowed regex patterns.
     *
     * @param value   the input string to validate
     * @param context validation context
     * @return true if valid or null, false otherwise
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;

        return compiledPatterns.stream().anyMatch(pattern -> pattern.matcher(value).matches());
    }
}

