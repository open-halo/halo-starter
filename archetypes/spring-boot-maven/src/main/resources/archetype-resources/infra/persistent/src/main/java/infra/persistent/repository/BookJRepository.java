#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infra.persistent.repository;

import org.babyfish.jimmer.spring.repository.JRepository;
import ${package}.infra.persistent.entity.Book;
import ${package}.infra.persistent.entity.Tables;

public interface BookJRepository extends JRepository<Book, Long>, Tables {
}
