#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.halo.infra.persistent.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import ${package}.halo.core.model.Book;

import java.util.List;

@Named
@Singleton
public class BookRepository implements PanacheRepository<Book> {
    public List<Book> findByAuthorId(long authorId) {
        return find("author_id", authorId).stream().toList();
    }
}
