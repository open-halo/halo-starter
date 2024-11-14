package com.example.halo.core.service;

import com.example.halo.core.model.Author;
import com.example.halo.core.model.Book;
import com.example.halo.core.model.Store;
import com.example.halo.core.model.base.ApiResult;
import com.example.halo.core.model.base.PagedRequest;
import com.example.halo.core.model.base.PagedResult;
import com.example.halo.core.model.dto.BookPublishRequest;


public interface IAuthorService {

    ApiResult<Long> register(Author author);
    ApiResult<Long> publishBook(BookPublishRequest publishRequest);
    PagedResult<Book> fetchAllBooks(PagedRequest<Long> requestWithAuthorId);

    PagedResult<Store> findAllStores(PagedRequest<Long> requestWithBookId);
}
