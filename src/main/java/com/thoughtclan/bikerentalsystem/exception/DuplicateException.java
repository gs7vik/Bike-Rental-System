package com.thoughtclan.bikerentalsystem.exception;

public class DuplicateException extends RuntimeException{

    public DuplicateException (String error){
        super(error);
    }
}
