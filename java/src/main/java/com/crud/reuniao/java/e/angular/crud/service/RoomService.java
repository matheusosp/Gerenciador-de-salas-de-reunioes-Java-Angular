package com.crud.reuniao.java.e.angular.crud.service;


import com.crud.reuniao.java.e.angular.crud.dto.RoomDTO;
import com.crud.reuniao.java.e.angular.crud.exception.RoomAlreadyRegisteredException;
import com.crud.reuniao.java.e.angular.crud.model.Room;
import com.crud.reuniao.java.e.angular.crud.exception.RoomNotFoundException;
import com.crud.reuniao.java.e.angular.crud.mapper.RoomMapper;
import com.crud.reuniao.java.e.angular.crud.repository.RoomRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomService {

    private final RoomRepository repository;

    private final RoomMapper roomMapper = RoomMapper.INSTANCE;

    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }

    public List<Room> findAll(){
        List<Room> room = repository.findAll();
        return room;
    }

    public Room findById(Long id) throws RoomNotFoundException {
        Room room = verifyIfExists(id);
        return room;
    }

    public Room create(Room room) throws RoomAlreadyRegisteredException {
        Optional<Room> alreadyRegistered = repository.findByName(room.getName());
        if (alreadyRegistered.isPresent()) {
            throw new RoomAlreadyRegisteredException(String.format("Room with name %s already registered in the system.", room.getName()));
        }
        System.out.println("test1"+room.toString());
        Room savedRoom = repository.save(room);
        System.out.println(savedRoom.toString());
        return savedRoom;
    }

    public void updateById(Long id, RoomDTO roomDTO) throws RoomNotFoundException{
        verifyIfExists(id);
        Room updatedRoom = roomMapper.toModel(roomDTO);
        updatedRoom.setId(id);
        repository.save(updatedRoom);
    }

    public void deleteById(Long id) throws RoomNotFoundException {
        verifyIfExists(id);
        repository.deleteById(id);

    }
    private Room verifyIfExists(Long id) throws RoomNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RoomNotFoundException(id));
    }

}
