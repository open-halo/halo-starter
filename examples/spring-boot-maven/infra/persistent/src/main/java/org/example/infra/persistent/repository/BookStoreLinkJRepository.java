package org.example.infra.persistent.repository;

import org.babyfish.jimmer.spring.repository.JRepository;
import org.example.infra.persistent.entity.BookStoreLink;

public interface BookStoreLinkJRepository extends JRepository<BookStoreLink, Long> {
}
