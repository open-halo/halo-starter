package org.example.halo.infra.persistent.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.example.halo.infra.persistent.entity.Users;

@ApplicationScoped
public class UserJRepository implements PanacheRepository<Users> {
    public Users findByEmail(String email) {
        return find("email", email).firstResult();
    }
}
