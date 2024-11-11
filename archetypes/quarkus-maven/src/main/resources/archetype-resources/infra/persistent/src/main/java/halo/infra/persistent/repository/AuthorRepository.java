#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.halo.infra.persistent.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import ${package}.halo.core.model.Author;

@Named
@Singleton
public class AuthorRepository implements PanacheRepository<Author> {

}
