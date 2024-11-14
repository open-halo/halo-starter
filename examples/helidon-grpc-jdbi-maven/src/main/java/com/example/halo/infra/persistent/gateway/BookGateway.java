package com.example.halo.infra.persistent.gateway;

import com.example.halo.core.gateway.IBookGateway;
import com.example.halo.core.model.Book;
import com.example.halo.core.model.base.ApiResult;
import com.example.halo.infra.persistent.entity.BookEntity;
import com.example.halo.infra.persistent.mapper.BookDao;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Singleton
public class BookGateway implements IBookGateway {
    private BookDao bookDao;

    @Inject
    public BookGateway(BookDao bookMapper) {
        this.bookDao = bookMapper;
    }

    @Mapper
    interface BookGatewayMapper {
        BookGatewayMapper INSTANCE = Mappers.getMapper(BookGatewayMapper.class);
        Book entityToModel(BookEntity bookEntity);

    }


    @Override
    public ApiResult<Book> fetch(long bookId) {
        BookEntity bookEntity = bookDao.fetchOneById(bookId);
        Book book = BookGatewayMapper.INSTANCE.entityToModel(bookEntity);
        return ApiResult.ofSuccess(book);
    }
}
