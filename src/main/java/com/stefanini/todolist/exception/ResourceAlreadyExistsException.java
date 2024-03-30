package com.stefanini.todolist.exception;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(String message){
        super(message);
    }
}