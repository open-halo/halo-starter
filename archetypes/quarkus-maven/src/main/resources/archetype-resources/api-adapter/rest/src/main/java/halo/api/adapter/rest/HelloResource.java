#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.halo.api.adapter.rest;

import jakarta.inject.Named;
import ${package}.halo.api.rest.IHelloResource;

@Named
public class HelloResource implements IHelloResource {
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
