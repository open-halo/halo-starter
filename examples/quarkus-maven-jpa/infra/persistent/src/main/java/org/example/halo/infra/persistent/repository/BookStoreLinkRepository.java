package org.example.halo.infra.persistent.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import org.example.halo.core.model.BookStoreLink;

@Named
@Singleton
public class BookStoreLinkRepository implements PanacheRepository<BookStoreLink> {
}
