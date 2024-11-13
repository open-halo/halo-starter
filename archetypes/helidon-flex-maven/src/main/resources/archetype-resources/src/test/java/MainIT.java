#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import io.helidon.webclient.http1.Http1Client;
import io.helidon.webserver.testing.junit5.ServerTest;

@ServerTest
class MainIT extends AbstractMainTest {
    MainIT(Http1Client client) {
        super(client);
    }
}