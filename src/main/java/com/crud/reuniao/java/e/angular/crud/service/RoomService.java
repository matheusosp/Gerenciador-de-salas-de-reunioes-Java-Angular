package com.crud.reuniao.java.e.angular.crud.service;

import com.crud.reuniao.java.e.angular.crud.dto.RoomDTO;
import com.crud.reuniao.java.e.angular.crud.exception.RoomNotFoundException;
import com.crud.reuniao.java.e.angular.crud.mapper.RoomMapper;
import com.crud.reuniao.java.e.angular.crud.model.Room;
import com.crud.reuniao.java.e.angular.crud.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RoomService {

    RoomRepository repository;

    private final RoomMapper roomMapper = RoomMapper.INSTANCE;

    public List<Room> findAll(){
        return repository.findAll();
    }

    public Room findById(Long id) throws RoomNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RoomNotFoundException(id));
    }

    public Room create(RoomDTO roomDTO) {
        Room room = roomMapper.toModel(roomDTO);
        Room savedRoom = repository.save(room);

        return savedRoom;
    }

    public Room updateById(Long id, RoomDTO roomDTO) throws RoomNotFoundException{
        verifyIfExists(id);

        Room updatedRoom = roomMapper.toModel(roomDTO);
        Room savedRoom = repository.save(updatedRoom);

        return savedRoom;
    }

    public void deleteById(Long id) throws RoomNotFoundException {
        verifyIfExists(id);

        repository.deleteById(id);

    }
    private Room verifyIfExists(Long id) throws RoomNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));
    }


}
