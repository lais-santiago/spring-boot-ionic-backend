package com.laissantiago.cursomc.services.exceptions;

public class DataIntegrityException extends RuntimeException{
  
  private static final long serialVersionUID = 7479883218143303914L;
  
  public DataIntegrityException(String msg){
    super(msg);
  }
  
  public DataIntegrityException(String msg, Throwable cause){
    super(msg, cause);
  }
}
