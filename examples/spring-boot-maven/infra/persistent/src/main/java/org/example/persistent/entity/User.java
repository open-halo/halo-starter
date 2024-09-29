package org.example.persistent.entity;

import org.babyfish.jimmer.sql.Entity;
import org.babyfish.jimmer.sql.Id;


@Entity
public interface User {
    @Id
    String name();

    Integer age();
}
