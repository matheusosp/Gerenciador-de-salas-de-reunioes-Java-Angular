package com.crud.reuniao.java.e.angular.crud.exception;

public class RoomNotFoundException extends Exception{

    public RoomNotFoundException(Long id) {

        super(String.format("Room with ID %s not found!", id));

    }

}
