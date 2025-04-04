package com.var.util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.var.exception.ProductNotFoundException;
//@ControllerAdvice  //GlobalException handling
public class ExceptionAdvice {
    
    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity blogNotFoundException(ProductNotFoundException productException) {
        return new ResponseEntity("Product NotFound", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> databaseConnectionFailsException(Exception exception) {
        return new ResponseEntity<>("Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}