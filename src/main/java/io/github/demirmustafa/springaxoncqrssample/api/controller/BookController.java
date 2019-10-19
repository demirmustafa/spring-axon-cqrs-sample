package io.github.demirmustafa.springaxoncqrssample.api.controller;

import io.github.demirmustafa.springaxoncqrssample.domain.command.AddBookCommand;
import io.github.demirmustafa.springaxoncqrssample.domain.command.DeleteBookByIdCommand;
import io.github.demirmustafa.springaxoncqrssample.domain.command.validator.AddBookCommandValidator;
import io.github.demirmustafa.springaxoncqrssample.domain.query.GetAllBooksQuery;
import io.github.demirmustafa.springaxoncqrssample.domain.query.GetBookByIdQuery;
import io.github.demirmustafa.springaxoncqrssample.validator.annotation.Valid;
import io.github.demirmustafa.springaxoncqrssample.validator.annotation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@RequestMapping("/books")
@RestController
@RequiredArgsConstructor
public class BookController {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    @GetMapping
    @SneakyThrows
    public Flux getAll() {
        CompletableFuture<Flux> query = queryGateway.query(new GetAllBooksQuery(), Flux.class);
        return query.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Validator(validator = AddBookCommandValidator.class)
    public void addBook(@Valid @RequestBody AddBookCommand command) {
        commandGateway.send(command);
    }

    @GetMapping("/{id}")
    @SneakyThrows
    public Mono getBook(@PathVariable String id) {
        GetBookByIdQuery query = GetBookByIdQuery.builder()
                .id(id)
                .build();
        return queryGateway.query(query, Mono.class).get();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable String id) {
        DeleteBookByIdCommand command = DeleteBookByIdCommand.builder()
                .id(id)
                .build();
        commandGateway.send(command);
    }
}
