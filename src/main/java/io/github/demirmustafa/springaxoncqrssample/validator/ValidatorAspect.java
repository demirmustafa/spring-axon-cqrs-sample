package io.github.demirmustafa.springaxoncqrssample.validator;

import io.github.demirmustafa.springaxoncqrssample.validator.annotation.Valid;
import io.github.demirmustafa.springaxoncqrssample.validator.annotation.Validator;
import io.github.demirmustafa.springaxoncqrssample.validator.contract.IValidator;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@Aspect
@Component
@RequiredArgsConstructor
public class ValidatorAspect {

    private final AutowireCapableBeanFactory beanFactory;

    @Before("@annotation(validator)")
    public void validator(JoinPoint joinPoint, Validator validator) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Parameter[] parameters = method.getParameters();
        Object[] args = joinPoint.getArgs();

        IValidator v = null;
        if (!validator.validator().isInterface()) {
            v = beanFactory.createBean(validator.validator());
        }

        for (int i = 0; i < method.getParameterCount(); i++) {
            Parameter parameter = parameters[i];
            Object arg = args[i];

            if (parameter.isAnnotationPresent(Valid.class)) {
                v.validate(arg);
            }
        }
    }
}
