package com.thoughtclan.bikerentalsystem.exception;

public class EntityNotFoundException extends RuntimeException{

    String code;

    public EntityNotFoundException( String msg){
        super(msg);
    }

    public EntityNotFoundException( String msg, String code ){
        super(msg);
        this.code = code;
    }

}
