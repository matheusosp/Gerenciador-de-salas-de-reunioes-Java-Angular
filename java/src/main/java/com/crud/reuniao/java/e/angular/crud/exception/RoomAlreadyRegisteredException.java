package com.crud.reuniao.java.e.angular.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RoomAlreadyRegisteredException extends Exception{

    public RoomAlreadyRegisteredException(String message) {
        super(message);
    }
}
