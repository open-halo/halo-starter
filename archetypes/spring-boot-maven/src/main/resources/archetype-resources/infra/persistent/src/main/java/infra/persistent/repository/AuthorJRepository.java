#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infra.persistent.repository;

import org.babyfish.jimmer.spring.repository.JRepository;
import ${package}.infra.persistent.entity.Author;
import ${package}.infra.persistent.entity.Tables;

public interface AuthorJRepository extends JRepository<Author, Long>, Tables {

}
