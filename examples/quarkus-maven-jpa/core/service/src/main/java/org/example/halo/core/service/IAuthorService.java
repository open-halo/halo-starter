package org.example.halo.core.service;

import jakarta.transaction.Transactional;
import org.example.halo.core.model.Author;
import org.example.halo.core.model.Book;
import org.example.halo.core.model.Store;
import org.example.halo.core.model.base.ApiResult;
import org.example.halo.core.model.base.PagedRequest;
import org.example.halo.core.model.base.PagedResult;
import org.example.halo.core.model.dto.BookPublishRequest;

public interface IAuthorService {

    ApiResult<Long> register(Author author);
    ApiResult<Long> publishBook(BookPublishRequest publishRequest);
    PagedResult<Book> fetchAllBooks(PagedRequest<Long> requestWithAuthorId);

    PagedResult<Store> findAllStores(PagedRequest<Long> requestWithBookId);
}
