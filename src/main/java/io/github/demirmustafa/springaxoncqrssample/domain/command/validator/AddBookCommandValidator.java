package io.github.demirmustafa.springaxoncqrssample.domain.command.validator;

import io.github.demirmustafa.springaxoncqrssample.domain.command.AddBookCommand;
import io.github.demirmustafa.springaxoncqrssample.exception.BusinessException;
import io.github.demirmustafa.springaxoncqrssample.exception.faultcode.BusinessFaultCode;
import io.github.demirmustafa.springaxoncqrssample.validator.contract.IValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;

@Slf4j
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AddBookCommandValidator implements IValidator<AddBookCommand> {

    @Override
    public void validate(AddBookCommand model) {
        if (StringUtils.isEmpty(model.getName())) {
            log.error("[AddBookCommandValidator] invalid book name");
            throw new BusinessException(BusinessFaultCode.EMPTY_BOOK_NAME);
        }

        if (StringUtils.isEmpty(model.getIsbn())) {
            log.error("[AddBookCommandHandler] invalid book isbn");
            throw new BusinessException(BusinessFaultCode.EMPTY_BOOK_ISBN);
        }

        if (StringUtils.isEmpty(model.getAuthor())) {
            log.error("[AddBookCommandHandler] invalid book author");
            throw new BusinessException(BusinessFaultCode.EMPTY_BOOK_AUTHOR);
        }
    }
}
