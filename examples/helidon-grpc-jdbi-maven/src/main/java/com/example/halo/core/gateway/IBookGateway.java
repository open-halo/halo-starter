package com.example.halo.core.gateway;

import com.example.halo.core.model.Book;
import com.example.halo.core.model.base.ApiResult;

public interface IBookGateway {
    ApiResult<Book> fetch(long bookId);

}
