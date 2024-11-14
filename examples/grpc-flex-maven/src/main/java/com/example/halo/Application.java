
package com.example.halo;




import com.example.halo.starter.GrpcServer;
import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * The application main class.
 */
@Slf4j
public class Application {


    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args)  {
        final GrpcServer server = new GrpcServer();
        server.run();
    }

}