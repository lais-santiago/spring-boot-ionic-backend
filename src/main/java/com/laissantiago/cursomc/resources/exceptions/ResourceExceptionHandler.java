package com.laissantiago.cursomc.resources.exceptions;

import com.laissantiago.cursomc.services.exceptions.DataIntegrityException;
import com.laissantiago.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
  
  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
    
    var err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
  }
  
  @ExceptionHandler(DataIntegrityException.class)
  public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request){
    
    var err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
  }
  
}
