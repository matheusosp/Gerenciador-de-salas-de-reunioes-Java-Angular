package com.crud.reuniao.java.e.angular.crud.controller;

import com.crud.reuniao.java.e.angular.crud.dto.RoomDTO;
import com.crud.reuniao.java.e.angular.crud.exception.RoomNotFoundException;
import com.crud.reuniao.java.e.angular.crud.model.Room;
import com.crud.reuniao.java.e.angular.crud.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController @CrossOrigin("http://localhost:4200")
@RequestMapping("api/v1")
public class RoomController {

    @Autowired
    RoomService service;

    @GetMapping("/rooms")
    public List<Room> listAll(){
        return service.findAll();
    }

    @GetMapping("/room/{id}")
    public Room findById(@PathVariable("id") Long id) throws RoomNotFoundException {

        return service.findById(id);

    }

    @PostMapping("/rooms")
    @ResponseStatus(HttpStatus.CREATED)
    public Room createRoom(@Valid @RequestBody RoomDTO room) {
        return service.create(room);
    }

    @PutMapping("/rooms/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Room updateRoom(@PathVariable(value = "id") Long roomId,
                                             @Valid @RequestBody RoomDTO roomDetails) throws RoomNotFoundException {
        return service.updateById(roomId,roomDetails);
    }

    @DeleteMapping("/rooms/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoom(@PathVariable(value = "id") Long roomId) throws RoomNotFoundException{
        service.deleteById(roomId);
    }
}
