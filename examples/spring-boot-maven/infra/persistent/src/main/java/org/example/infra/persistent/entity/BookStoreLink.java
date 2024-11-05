package org.example.infra.persistent.entity;

import org.babyfish.jimmer.sql.DatabaseValidationIgnore;
import org.babyfish.jimmer.sql.Entity;
import org.example.infra.persistent.entity.base.BaseEntity;

@Entity
@DatabaseValidationIgnore
public interface BookStoreLink extends BaseEntity {

    long bookId();

    long storeId();

    int remainCount();
}
