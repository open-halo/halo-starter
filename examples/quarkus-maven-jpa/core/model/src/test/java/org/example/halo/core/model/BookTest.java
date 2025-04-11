package org.example.halo.core.model;

import org.example.halo.core.model.base.Gender;
import org.example.halo.core.model.base.ValidatorTest;
import org.junit.jupiter.params.provider.Arguments;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class BookTest extends ValidatorTest<Book> {
    private static Stream<Arguments> invalidEntities() {
        var book1 = Book.builder()
                .id(101L)
                .name("Effective Java")
                .build();


        return Stream.of(
                Arguments.of(book1)
        );
    }

    private static Stream<Arguments> validEntities() {
        var book1 =  Book.builder()
                .id(102L)
                .price(new BigDecimal("10.5"))
                .name("Effective C++")
                .edition(1)
                .author(Author.builder().id(102L).build())
                .build();

        return Stream.of(
                Arguments.of(book1)
        );
    }

}
