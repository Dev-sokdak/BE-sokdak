package com.example.devsokdak.global.exception;

import com.example.devsokdak.global.MsgResponseDto;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public MsgResponseDto customeException(final CustomException customException) {
        return new MsgResponseDto(customException);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object processValidationError(MethodArgumentNotValidException ex) {
        return new MsgResponseDto(ex);
    }


}
