package com.crud.reuniao.java.e.angular.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RoomAlreadyRegisteredException extends Exception{

    private static final long serialVersionUID = 1L;

    public RoomAlreadyRegisteredException(String name) {
        super(String.format("Room with name %s already registered in the system.", name));
    }
}
