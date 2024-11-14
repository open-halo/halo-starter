package com.example.halo.core.service.impl;

import com.example.halo.core.gateway.IBookGateway;
import com.example.halo.core.model.Book;
import com.example.halo.core.model.base.ApiResult;
import com.example.halo.core.service.IBookService;
import com.example.halo.infra.persistent.gateway.BookGateway;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class BookService implements IBookService {

    private IBookGateway bookGateway;

    @Inject
    public BookService(BookGateway bookGateway) {
        this.bookGateway = bookGateway;
    }

    @Override
    public ApiResult<Book> fetch(long bookId) {
        return bookGateway.fetch(bookId);
    }
}
