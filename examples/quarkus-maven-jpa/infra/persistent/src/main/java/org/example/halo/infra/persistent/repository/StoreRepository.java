package org.example.halo.infra.persistent.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import org.example.halo.core.model.Store;

import java.util.List;

@Named
@Singleton
public class StoreRepository implements PanacheRepository<Store> {
}
