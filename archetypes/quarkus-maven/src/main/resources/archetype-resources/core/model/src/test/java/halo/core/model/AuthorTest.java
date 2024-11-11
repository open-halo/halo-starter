#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.halo.core.model;

import ${package}.halo.core.model.base.Gender;
import ${package}.halo.core.model.base.ValidatorTest;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

public class AuthorTest extends ValidatorTest<Author> {
    private static Stream<Arguments> invalidEntities() {
        var author1 = Author.builder()
                .id(101L)
                .gender(Gender.MALE)
                .email("sdfsdf")
                .name("David")
                .build();

        var author2 = Author.builder()
                .id(101L)
                .gender(Gender.MALE)
                .email("sdfsdf@example.com")
                .name("")
                .build();

        var author3 = Author.builder()
                .gender(Gender.MALE)
                .email("sdfsdf@example.com")
                .name("hello")
                .build();

        return Stream.of(
                Arguments.of(author1),
                Arguments.of(author2),
                Arguments.of(author3)
        );
    }

    private static Stream<Arguments> validEntities() {
        var author1 =  Author.builder()
                .id(102L)
                .gender(Gender.MALE)
                .email("hello@example.com")
                .name("Allen")
                .build();

        return Stream.of(
                Arguments.of(author1)
        );
    }

}
