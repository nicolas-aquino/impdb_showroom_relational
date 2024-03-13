package com.meli.showroom_relacional.exception;

import com.meli.showroom_relacional.dto.response.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException e) {
        MessageDto exceptionDto = new MessageDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto,  HttpStatus.NOT_FOUND);
    }
}
