package org.example.infra.persistent.repository;

import org.babyfish.jimmer.spring.repository.JRepository;
import org.example.infra.persistent.entity.Store;
import org.example.infra.persistent.entity.Tables;

public interface StoreJRepository extends JRepository<Store, Long>, Tables {
}
