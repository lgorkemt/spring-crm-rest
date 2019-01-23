package com.turan.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

    // Add an exception for the customers who are not found
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc){
        // create CustomerErrorResponse
        CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse();

        customerErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        customerErrorResponse.setMessage(exc.getMessage());
        customerErrorResponse.setTimeStamp(System.currentTimeMillis());

        ResponseEntity responseEntity = new ResponseEntity<>(customerErrorResponse, HttpStatus.NOT_FOUND);

        // return responseEntity

        return responseEntity;
    }


    // Add an exception for other types of faulty entries
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleBadRequestException(Exception exc){
        // create CustomerErrorResponse
        CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse();

        customerErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        customerErrorResponse.setMessage(exc.getMessage());
        customerErrorResponse.setTimeStamp(System.currentTimeMillis());

        ResponseEntity responseEntity = new ResponseEntity<>(customerErrorResponse, HttpStatus.BAD_REQUEST);

        // return responseEntity

        return responseEntity;
    }
}
