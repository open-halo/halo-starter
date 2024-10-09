package org.example.infra.persistent.entity;

import org.babyfish.jimmer.sql.Entity;
import org.babyfish.jimmer.sql.Id;


@Entity
public interface User {
    @Id
    long id();

    String name();

    String email();

    Integer age();
}
