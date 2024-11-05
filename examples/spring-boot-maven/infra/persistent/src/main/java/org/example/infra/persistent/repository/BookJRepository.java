package org.example.infra.persistent.repository;

import org.babyfish.jimmer.spring.repository.JRepository;
import org.example.infra.persistent.entity.Book;
import org.example.infra.persistent.entity.Tables;

public interface BookJRepository extends JRepository<Book, Long>, Tables {
}
