#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.gateway;

public interface IIdGenerator {
    long nextLongId();
}
