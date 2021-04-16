package com.laissantiago.cursomc.services.exceptions;

public class ObjectNotFoundException  extends RuntimeException{

    private static final long serialVersionUID = 7479883218143303914L;

    public ObjectNotFoundException(String msg){
        super(msg);
    }

    public ObjectNotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }
}
