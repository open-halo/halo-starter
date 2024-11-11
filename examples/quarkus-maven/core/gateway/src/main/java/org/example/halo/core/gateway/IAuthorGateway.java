package org.example.halo.core.gateway;

import org.example.halo.core.model.Author;
import org.example.halo.core.model.Book;
import org.example.halo.core.model.Store;
import org.example.halo.core.model.base.ApiResult;
import org.example.halo.core.model.base.PagedRequest;
import org.example.halo.core.model.base.PagedResult;
import org.example.halo.core.model.dto.BookPublishRequest;

public interface IAuthorGateway {
    ApiResult<Void> register(Author author);
    ApiResult<Void> publishBook(BookPublishRequest publishRequest);
    PagedResult<Book> fetchAllBooks(PagedRequest<Long> requestWithAuthorId);

    PagedResult<Store> fetchAllStores(PagedRequest<Long> requestWithBookId);
}
