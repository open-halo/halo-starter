package org.example.halo.core.model.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.math.BigDecimal;

public class BigDecimalLengthValidator implements ConstraintValidator<BigDecimalLength, BigDecimal> {

    private int max;

    @Override
    public boolean isValid(BigDecimal value, ConstraintValidatorContext context) {
        return value == null || value.toString().length() <= max;
    }

    @Override
    public void initialize(BigDecimalLength constraintAnnotation) {
        this.max = constraintAnnotation.maxLength();
    }
}
