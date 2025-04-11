package org.example.halo.infra.persistent.repository;


import jakarta.inject.Named;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import org.example.halo.core.gateway.IAuthorGateway;
import org.example.halo.core.model.Author;
import org.example.halo.core.model.Book;
import org.example.halo.core.model.Store;
import org.example.halo.core.model.base.ApiResult;
import org.example.halo.core.model.base.PagedRequest;
import org.example.halo.core.model.base.PagedResult;
import org.example.halo.core.model.dto.BookPublishRequest;
import org.example.halo.infra.persistent.mapper.AuthorMapper;

@Named
@Singleton
@AllArgsConstructor
public class AuthorRepository  {

    private final AuthorMapper authorMapper;

//
//    public ApiResult<Void> insert(Author author) {
//        authorMapper.insert(author);
//        return null;
//    }
//
//    @Override
//    public ApiResult<Void> publishBook(BookPublishRequest publishRequest) {
//        return null;
//    }
//
//    @Override
//    public PagedResult<Book> fetchAllBooks(PagedRequest<Long> requestWithAuthorId) {
//        return null;
//    }
//
//    @Override
//    public PagedResult<Store> fetchAllStores(PagedRequest<Long> requestWithBookId) {
//        return null;
//    }
}
