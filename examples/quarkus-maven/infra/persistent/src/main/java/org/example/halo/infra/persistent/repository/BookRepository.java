package org.example.halo.infra.persistent.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import org.example.halo.core.model.Book;

import java.util.List;

@Named
@Singleton
public class BookRepository implements PanacheRepository<Book> {
    public List<Book> findByAuthorId(long authorId) {
        return find("author_id", authorId).stream().toList();
    }
}
