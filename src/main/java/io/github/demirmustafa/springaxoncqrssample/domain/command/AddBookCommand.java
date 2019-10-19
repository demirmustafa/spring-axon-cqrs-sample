package io.github.demirmustafa.springaxoncqrssample.domain.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddBookCommand {

    private String name;
    private String author;
    private String isbn;
}
