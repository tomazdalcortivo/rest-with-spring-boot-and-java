package br.com.tomaz.api_gateway.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException implements Serializable {

    public UnsupportedMathOperationException(String str) {
        super(str);
    }
}
