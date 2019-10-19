package io.github.demirmustafa.springaxoncqrssample.exception.faultcode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BusinessFaultCode {

  EMPTY_BOOK_NAME("error.book.name.empty", 400),
  EMPTY_BOOK_ISBN("error.book.isbn.empty", 400),
  EMPTY_BOOK_AUTHOR("error.book.author.empty", 400);

  private final String code;
  private final Integer status;
}
