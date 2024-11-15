#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dubbo.grpc.${artifactId};

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.springboot.demo.idl.DubboGreeterTriple;
import org.apache.dubbo.springboot.demo.idl.GreeterReply;
import org.apache.dubbo.springboot.demo.idl.GreeterRequest;

@DubboService
public class GreeterImpl extends DubboGreeterTriple.GreeterImplBase {
//    private static final Logger LOGGER = LoggerFactory.getLogger(GreeterImpl.class);

    @Override
    public GreeterReply greet(GreeterRequest request) {
//        LOGGER.info("Server received greet request {}" , request);
        return GreeterReply.newBuilder()
                .setMessage("hello, " + request.getName() + "this is dubbo3!")
                .build();
    }

}