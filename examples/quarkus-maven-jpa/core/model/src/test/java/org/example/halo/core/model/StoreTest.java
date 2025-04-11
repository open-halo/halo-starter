package org.example.halo.core.model;

import org.example.halo.core.model.base.ValidatorTest;
import org.junit.jupiter.params.provider.Arguments;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class StoreTest extends ValidatorTest<Store> {
    private static Stream<Arguments> invalidEntities() {
        var book1 = Store.builder()
                .id(101L)
                .name("Effective Java")
                .build();


        return Stream.of(
                Arguments.of(book1)
        );
    }

    private static Stream<Arguments> validEntities() {
        var book1 = Store.builder()
                .id(101L)
                .name("Effective Java")
                .website("www.hello.com")
                .build();

        return Stream.of(
                Arguments.of(book1)
        );
    }

}
