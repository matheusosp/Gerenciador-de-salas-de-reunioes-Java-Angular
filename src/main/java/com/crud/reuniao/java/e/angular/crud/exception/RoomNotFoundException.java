package com.crud.reuniao.java.e.angular.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RoomNotFoundException extends Exception{

    private static final long serialVersionUID = 1L;

    public RoomNotFoundException(Long id) {

        super(String.format("Room with ID %s not found!", id));

    }

}
