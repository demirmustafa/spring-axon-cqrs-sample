package io.github.demirmustafa.springaxoncqrssample.exception;

import io.github.demirmustafa.springaxoncqrssample.exception.faultcode.BusinessFaultCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

  private final BusinessFaultCode faultCode;

  public BusinessException(BusinessFaultCode faultCode) {
    super();
    this.faultCode = faultCode;
  }
}
