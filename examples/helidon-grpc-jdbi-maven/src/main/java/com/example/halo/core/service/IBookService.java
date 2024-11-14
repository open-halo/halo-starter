package com.example.halo.core.service;

import com.example.halo.core.model.Book;
import com.example.halo.core.model.base.ApiResult;

public interface IBookService {
    ApiResult<Book> fetch(long bookId);
}
