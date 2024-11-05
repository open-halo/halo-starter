#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infra.persistent.entity;

import org.babyfish.jimmer.sql.DatabaseValidationIgnore;
import org.babyfish.jimmer.sql.Entity;
import ${package}.infra.persistent.entity.base.BaseEntity;

@Entity
@DatabaseValidationIgnore
public interface Author extends BaseEntity {

    String name();

    String email();

    String gender();

}
