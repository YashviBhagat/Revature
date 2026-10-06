package com.spring.demo.exceptions;


import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class StudentExceptionalHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleRecordNotFoundException(RecordNotFoundException e){
        ApiErrorResponse error = new ApiErrorResponse(HttpStatus.NOT_FOUND.value(),e.getMessage(),System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }



    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public ResponseEntity<StudentErrorResponse>handleValidationException(
    //     MethodArgumentNotValidException e){
    //     StudentErrorResponse error =new StudentErrorResponse(
    //         HttpStatus.BAD_REQUEST.value(),
    //         "Validation failed. Please check your input.",
    //         System.currentTimeMillis());
        
    //     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    // }

    // logic is 
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse>handleValidationException(
        MethodArgumentNotValidException e
    ){

        String details = e.getBindingResult().getFieldErrors().stream()
            .map(error -> error.getField() + ":" + error.getDefaultMessage())
            .collect(Collectors.joining(";"));

        ApiErrorResponse error =new ApiErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            details,
            System.currentTimeMillis());
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler (MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiErrorResponse> handleMethodArgsException(
        MethodArgumentTypeMismatchException e
    ){
        ApiErrorResponse error = new ApiErrorResponse(
            HttpStatus.BAD_REQUEST.value(),"The argument(s) provided is(are) not valid. Please only supply valid arguments.", 
                                
            System.currentTimeMillis());
        return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(error);

    }


    // @ExceptionHandler (Exception.class)
    // public ResponseEntity<ApiErrorResponse> handleGenericException(Exception e){

    // ApiErrorResponse error =new ApiErrorResponse(
    //         HttpStatus.INTERNAL_SERVER_ERROR.value(),
    //         "An internal error occurred.",
    //         System.currentTimeMillis());
        
    // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);

    // }

}

