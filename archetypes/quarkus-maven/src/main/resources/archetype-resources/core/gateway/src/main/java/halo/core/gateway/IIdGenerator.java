#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.halo.core.gateway;

public interface IIdGenerator {
    long nextLongId();
}
