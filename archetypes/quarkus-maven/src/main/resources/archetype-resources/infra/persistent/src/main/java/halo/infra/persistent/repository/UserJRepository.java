#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.halo.infra.persistent.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import ${package}.halo.infra.persistent.entity.Users;

@ApplicationScoped
public class UserJRepository implements PanacheRepository<Users> {
    public Users findByEmail(String email) {
        return find("email", email).firstResult();
    }
}
