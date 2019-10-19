package io.github.demirmustafa.springaxoncqrssample.validator.annotation;

import io.github.demirmustafa.springaxoncqrssample.validator.contract.IValidator;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Component
@Target(value = {ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Validator {

    Class<? extends IValidator> validator() default IValidator.class;
}
