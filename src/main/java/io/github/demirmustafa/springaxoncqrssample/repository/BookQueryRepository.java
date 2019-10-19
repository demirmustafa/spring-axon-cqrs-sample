package io.github.demirmustafa.springaxoncqrssample.repository;

import io.github.demirmustafa.springaxoncqrssample.domain.Book;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;

public interface BookQueryRepository extends ReactiveCouchbaseRepository<Book, String> {
}
