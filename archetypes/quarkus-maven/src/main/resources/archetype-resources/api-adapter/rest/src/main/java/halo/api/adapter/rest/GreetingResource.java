#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.halo.api.adapter.rest;


import jakarta.inject.Named;

@Named
public class GreetingResource implements IGreetingResource {
    @Override
    public String hello() {
        return "Hello from Quarkus REST";
    }
}
