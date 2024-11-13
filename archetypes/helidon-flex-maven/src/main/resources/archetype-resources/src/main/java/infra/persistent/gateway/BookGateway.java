#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infra.persistent.gateway;

import ${package}.core.gateway.IBookGateway;
import ${package}.core.model.Book;
import ${package}.core.model.base.ApiResult;
import ${package}.infra.persistent.entity.BookEntity;
import ${package}.infra.persistent.mapper.BookMapper;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Singleton
public class BookGateway implements IBookGateway {
    private BookMapper bookMapper;

    @Inject
    public BookGateway(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Mapper
    interface BookGatewayMapper {
        BookGatewayMapper INSTANCE = Mappers.getMapper(BookGatewayMapper.class);
        Book entityToModel(BookEntity bookEntity);

    }


    @Override
    public ApiResult<Book> fetch(long bookId) {
        BookEntity bookEntity = bookMapper.selectOneById(bookId);
        Book book = BookGatewayMapper.INSTANCE.entityToModel(bookEntity);
        return ApiResult.ofSuccess(book);
    }
}
