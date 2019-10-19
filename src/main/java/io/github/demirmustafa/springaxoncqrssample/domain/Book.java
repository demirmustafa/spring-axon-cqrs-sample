package io.github.demirmustafa.springaxoncqrssample.domain;

import io.github.demirmustafa.springaxoncqrssample.domain.command.AddBookCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Book {

    @Id
    private String id;
    private String name;
    private String author;
    private String isbn;

    public Book(AddBookCommand addBookCommand) {
        this.name = addBookCommand.getName();
        this.author = addBookCommand.getAuthor();
        this.isbn = addBookCommand.getIsbn();
    }
}
