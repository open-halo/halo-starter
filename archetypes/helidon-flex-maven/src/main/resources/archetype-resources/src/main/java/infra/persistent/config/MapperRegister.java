#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infra.persistent.config;

import ${package}.infra.persistent.mapper.AuthorMapper;
import ${package}.infra.persistent.mapper.BookMapper;
import ${package}.infra.persistent.mapper.BookStoreLinkMapper;
import ${package}.infra.persistent.mapper.StoreMapper;
import com.mybatisflex.core.MybatisFlexBootstrap;
import io.avaje.inject.Bean;
import io.avaje.inject.Factory;
import jakarta.inject.Inject;

import javax.sql.DataSource;

@Factory
public class MapperRegister {

    @Bean
    MybatisFlexBootstrap getMybatisFlexBootstrap(DataSource dataSource) {
        return MybatisFlexBootstrap.getInstance()
                .setDataSource(dataSource)
                .addMapper(BookMapper.class)
                .start();
    }

    @Bean
    AuthorMapper getAuthorMapper(MybatisFlexBootstrap bootstrap) {
        return bootstrap.getMapper(AuthorMapper.class);
    }

    @Bean
    BookMapper getBookMapper(MybatisFlexBootstrap bootstrap) {
        return bootstrap.getMapper(BookMapper.class);
    }

    @Bean
    StoreMapper getStoreMapper(MybatisFlexBootstrap bootstrap) {
        return bootstrap.getMapper(StoreMapper.class);
    }

    @Bean
    BookStoreLinkMapper getBookStoreLinkMapper(MybatisFlexBootstrap bootstrap) {
        return bootstrap.getMapper(BookStoreLinkMapper.class);
    }

}
