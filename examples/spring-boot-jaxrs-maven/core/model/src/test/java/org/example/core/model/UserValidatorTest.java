package org.example.core.model;

import org.example.core.model.base.ValidatorTest;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class UserValidatorTest extends ValidatorTest<User> {
    private static Stream<Arguments> invalidEntities() {
        return Stream.of(Arguments.of(givenUserWithNullID()),
            Arguments.of(givenUserWithEmptyName()), Arguments.of(givenUserWithInvalidEmail()));
    }

    private static Stream<Arguments> validEntities() {
        return Stream.of(Arguments.of(givenValidUser1()));
    }

    private static User givenValidUser1() {
        return new User(123L, "Julio", "hello@example.com", "13912341234");
    }

    public static User givenUserWithNullID() {
        return new User(null, "Julio", "hello@s.com", "123");
    }

    public static User givenUserWithEmptyName() {
        return new User(123L, "", "hello@s", "123");
    }

    public static User givenUserWithInvalidEmail() {
        return new User(123L, "name", "hello", "13912341234");
    }
}
