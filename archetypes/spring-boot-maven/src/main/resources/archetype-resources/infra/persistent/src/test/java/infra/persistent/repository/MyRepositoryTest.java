#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infra.persistent.repository;




import ${package}.infra.persistent.AppTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


//@SpringBootTest
//@ContextConfiguration(classes = AppTestConfig.class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
//@Sql(scripts = {"/sql/schema/schema.sql", "/sql/data/data.sql"})
//public class MyRepositoryTest {
//    @Autowired
//    private MyRepository myRepository;
//
//    @Test
//    public void testRepository() {
//        myRepository.addUser("Allen", "allen@example.com");
//
//        List<Map<String, Object>> users = myRepository.findAllUsers();
//        assertEquals(users.size(), 3);
//    }
//}
