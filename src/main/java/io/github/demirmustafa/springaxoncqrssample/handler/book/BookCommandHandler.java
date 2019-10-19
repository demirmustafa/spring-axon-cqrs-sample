package io.github.demirmustafa.springaxoncqrssample.handler.book;

import io.github.demirmustafa.springaxoncqrssample.domain.Book;
import io.github.demirmustafa.springaxoncqrssample.domain.command.AddBookCommand;
import io.github.demirmustafa.springaxoncqrssample.domain.command.DeleteBookByIdCommand;
import io.github.demirmustafa.springaxoncqrssample.repository.BookCommandRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookCommandHandler {

    private final BookCommandRepository bookCommandRepository;

    @CommandHandler
    public void addBook(AddBookCommand command) {
        Book book = new Book(command);
        bookCommandRepository.save(book);
    }

    @CommandHandler
    public void deleteBook(DeleteBookByIdCommand command) {
        bookCommandRepository.deleteById(command.getId());
    }
}
