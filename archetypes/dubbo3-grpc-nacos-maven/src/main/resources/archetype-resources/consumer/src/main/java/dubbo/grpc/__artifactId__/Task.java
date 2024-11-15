#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dubbo.grpc.${artifactId};

import java.util.Date;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.springboot.demo.idl.Greeter;
import org.apache.dubbo.springboot.demo.idl.GreeterReply;
import org.apache.dubbo.springboot.demo.idl.GreeterRequest;
import org.apache.dubbo.springboot.demo.idl.Greeter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Task implements CommandLineRunner {
    @DubboReference
    private Greeter greeter;

    @Override
    public void run(String... args) throws Exception {
        GreeterReply result = greeter.greet(GreeterRequest.newBuilder().setName("name").build());
        System.out.println("Received result ======> " + result.getMessage());
    }
}