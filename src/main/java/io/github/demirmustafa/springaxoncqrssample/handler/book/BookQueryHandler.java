package io.github.demirmustafa.springaxoncqrssample.handler.book;

import io.github.demirmustafa.springaxoncqrssample.domain.Book;
import io.github.demirmustafa.springaxoncqrssample.domain.query.GetAllBooksQuery;
import io.github.demirmustafa.springaxoncqrssample.domain.query.GetBookByIdQuery;
import io.github.demirmustafa.springaxoncqrssample.repository.BookQueryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
public class BookQueryHandler {

    private final BookQueryRepository bookQueryRepository;

    @QueryHandler
    public Flux<Book> getAll(GetAllBooksQuery query) {
        return bookQueryRepository.findAll();
    }

    @QueryHandler
    public Mono<Book> get(GetBookByIdQuery query) {
        return bookQueryRepository.findById(query.getId());
    }
}
