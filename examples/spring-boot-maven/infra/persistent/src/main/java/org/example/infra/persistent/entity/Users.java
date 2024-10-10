package org.example.infra.persistent.entity;

import org.babyfish.jimmer.sql.DatabaseValidationIgnore;
import org.babyfish.jimmer.sql.Entity;
import org.babyfish.jimmer.sql.Id;


@Entity
@DatabaseValidationIgnore
public interface Users {
    @Id
    long id();

    String name();

    String email();

    Integer age();
}
