#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.halo.core.model.base;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class ValidatorTest<T> {
    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @MethodSource("invalidEntities")
    @ParameterizedTest
    void allValidatorsAreIncorrectlySet(T dto) {
        var constraintViolations = validator.validate(dto);
        assertFalse(constraintViolations.isEmpty());
    }

    @MethodSource("validEntities")
    @ParameterizedTest
    void allValidatorsAreCorrectlySet(T dto) {
        var constraintViolations = validator.validate(dto);
        assertTrue(constraintViolations.isEmpty());
    }
}
