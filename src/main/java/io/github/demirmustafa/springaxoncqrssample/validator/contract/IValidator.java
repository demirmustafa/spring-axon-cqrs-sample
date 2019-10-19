package io.github.demirmustafa.springaxoncqrssample.validator.contract;

public interface IValidator<T> {

    void validate(T model);
}
