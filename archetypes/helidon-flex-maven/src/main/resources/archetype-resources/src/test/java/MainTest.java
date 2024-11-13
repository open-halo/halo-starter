#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import io.helidon.webserver.testing.junit5.DirectClient;
import io.helidon.webserver.testing.junit5.RoutingTest;

@RoutingTest
class MainTest extends AbstractMainTest {
    MainTest(DirectClient client) {
        super(client);
    }
}