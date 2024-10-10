#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.model;

import lombok.Data;

@Data
public class User {
    long id;
    String name;
    String email;
}
