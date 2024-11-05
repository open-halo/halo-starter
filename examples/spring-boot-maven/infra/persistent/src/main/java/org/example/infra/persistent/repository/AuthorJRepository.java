package org.example.infra.persistent.repository;

import org.babyfish.jimmer.spring.repository.JRepository;
import org.example.infra.persistent.entity.Author;
import org.example.infra.persistent.entity.Tables;

public interface AuthorJRepository extends JRepository<Author, Long>, Tables {

}
