package org.example.infra.persistent.entity;

import org.babyfish.jimmer.sql.DatabaseValidationIgnore;
import org.babyfish.jimmer.sql.Entity;
import org.example.infra.persistent.entity.base.BaseEntity;
import java.math.BigDecimal;

@Entity
@DatabaseValidationIgnore
public interface Book extends BaseEntity {
    String name();

    int edition();

    BigDecimal price();

    long authorId();
}
