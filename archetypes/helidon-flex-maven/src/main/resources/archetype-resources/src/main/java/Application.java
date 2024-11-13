#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

package ${package};


import ${package}.bridge.grpc.GreeterGrpcService;
import ${package}.bridge.rest.GreetService;
import ${package}.core.gateway.IIdGenerator;
import ${package}.core.model.Book;
import ${package}.core.model.base.ApiResult;
import ${package}.core.service.IBookService;
import ${package}.core.service.ICalculator;
import ${package}.infra.persistent.config.H2Initializer;
import io.avaje.inject.BeanScope;
import io.helidon.common.parameters.Parameters;
import io.helidon.logging.common.LogConfig;
import io.helidon.config.Config;
import io.helidon.webserver.WebServer;
import io.helidon.webserver.grpc.GrpcRouting;
import io.helidon.webserver.http.HttpRouting;
import cn.hutool.json.JSONUtil;
import org.apache.ibatis.logging.LogFactory;

import java.util.Arrays;
import java.util.Map;


/**
 * The application main class.
 */
public class Application {


    /**
     * Cannot be instantiated.
     */
    private Application() {
    }



    /**
     * Application main entry point.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {

        // load logging configuration
        LogConfig.configureRuntime();

        // initialize global config from default configuration
        Config config = Config.create();
        Config.global(config);

        LogFactory.useSlf4jLogging();

        WebServer server = WebServer.builder()
                .config(config.get("server"))
                .routing(Application::routing)
                .addRouting(createGrpcRouting(config))
                .build()
                .start();

        BeanScope beanScope = BeanScope.builder().build();
        H2Initializer h2Initializer = beanScope.get(H2Initializer.class);
        h2Initializer.init();

        System.out.println("WEB server is up! http://localhost:" + server.port() + "/simple-greet");

    }


    private static GrpcRouting.Builder createGrpcRouting(Config config) {
        return GrpcRouting.builder()
                .service(new GreeterGrpcService());
    }

    /**
     * Updates HTTP Routing.
     */
    static void routing(HttpRouting.Builder routing) {
        BeanScope beanScope = BeanScope.builder().build();
        ICalculator calculator = beanScope.get(ICalculator.class);
        IIdGenerator idGenerator = beanScope.get(IIdGenerator.class);
        IBookService bookService = beanScope.get(IBookService.class);
        routing
//                .register("/greet", new GreetService())
                .get("/simple-greet", (req, res) -> res.send("Hello World!"))
                .get("/adder", (req, res) -> {
                    String dataString = req.query().getRaw("data");
                    int[] arr = Arrays.stream(dataString.split(",")).mapToInt(Integer::parseInt).toArray();
                    int sum = calculator.sum(arr);
                    res.send(String.valueOf(sum));
                })
                .get("/id", (req, res)-> {
                    long nextId = idGenerator.nextLongId();
                    res.send(String.valueOf(nextId));
                })

                .get("/book/{id}", (req, res)-> {
                    Parameters pathParams = req.path().pathParameters();
                    String idStr = pathParams.get("id");
                    long bookId = Long.valueOf(idStr);
                    ApiResult<Book> bookApiResult = bookService.fetch(bookId);
                    res.send(JSONUtil.toJsonStr(bookApiResult));
                })


        ;
    }
}