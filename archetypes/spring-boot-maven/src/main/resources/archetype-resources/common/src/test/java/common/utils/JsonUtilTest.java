#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.common.utils;

import cn.zhxu.data.Mapper;
import cn.zhxu.xjson.JsonKit;
import lombok.Data;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonUtilTest {

    @Data
    public static class User {
        String name;
        int    age;
    }

    @Test
    public void testJsonKit() {
        String json = "{${symbol_escape}"name${symbol_escape}":${symbol_escape}"Jack${symbol_escape}",${symbol_escape}"age${symbol_escape}":20}";
        Mapper mapper = JsonKit.toMapper(json);
        assertEquals(mapper.size(), 2);

        User user = JsonKit.toBean(User.class, json);
        assertEquals(user.age, 20);

        String jsonString = JsonKit.toJson(user);
        assertEquals(jsonString, "{${symbol_escape}"name${symbol_escape}":${symbol_escape}"Jack${symbol_escape}",${symbol_escape}"age${symbol_escape}":20}");
    }

}
