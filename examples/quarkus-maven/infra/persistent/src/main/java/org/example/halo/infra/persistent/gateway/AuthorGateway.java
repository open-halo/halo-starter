package org.example.halo.infra.persistent.gateway;

//import io.quarkus.hibernate.orm.panache.PanacheQuery;
//import io.quarkus.panache.common.Page;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.example.halo.core.gateway.IAuthorGateway;
import org.example.halo.core.gateway.IIdGenerator;
import org.example.halo.core.model.Author;
import org.example.halo.core.model.Book;
import org.example.halo.core.model.Store;
import org.example.halo.core.model.base.ApiResult;
import org.example.halo.core.model.base.PagedInfo;
import org.example.halo.core.model.base.PagedRequest;
import org.example.halo.core.model.base.PagedResult;
import org.example.halo.core.model.dto.BookPublishRequest;
import org.example.halo.infra.persistent.mapper.AuthorMapper;
import org.example.halo.infra.persistent.mapper.BookMapper;
import org.example.halo.infra.persistent.repository.AuthorRepository;
import org.example.halo.infra.persistent.repository.BookRepository;


import java.util.List;

@Slf4j
@Named
@Singleton
public class AuthorGateway implements IAuthorGateway {

    @Inject
    AuthorRepository authorRepository;

    @Inject
    BookMapper bookMapper;

    @Inject
    AuthorMapper authorMapper;

    @Inject
    BookRepository bookRepository;

    @Inject
    IIdGenerator idGenerator;

    @Override
    public ApiResult<Void> register(Author author) {
        log.info("register {}", author);
        authorMapper.insert(author);
        return ApiResult.ofSuccess();
    }

    @Override
    public ApiResult<Void> publishBook(BookPublishRequest publishRequest) {
        Book book = Book.builder()
                .id(idGenerator.nextLongId())
                .author(Author.builder().id(publishRequest.authorId()).build())
                .name(publishRequest.name())
                .edition(publishRequest.edition())
                .price(publishRequest.price())
                .build();
        bookMapper.insert(book);
        return ApiResult.ofSuccess();
    }

    @Override
    public PagedResult<Book> fetchAllBooks(PagedRequest<Long> request) {
//        Long authorId = request.getRequest();
//        Page page = PageMapper.INSTANCE.toPage(request.getPagination());
//        long totalCount = bookRepository.count("author_id", authorId);
//        PanacheQuery<Book> booksQuery = bookRepository.find("author_id", authorId);
//        List<Book> books = booksQuery.page(page)
//                .list();
//
//        PagedInfo pagedInfo = new PagedInfo(page.size, page.index, books.size(), totalCount);
//        return new PagedResult<>(pagedInfo, books);
        return null;
    }

    @Override
    public PagedResult<Store> fetchAllStores(PagedRequest<Long> request) {
        return null;
    }



}
