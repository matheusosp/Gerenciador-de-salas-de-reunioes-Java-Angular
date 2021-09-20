package com.crud.reuniao.java.e.angular.crud.mapper;

import com.crud.reuniao.java.e.angular.crud.dto.RoomDTO;
import com.crud.reuniao.java.e.angular.crud.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface RoomMapper {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    Room toModel(RoomDTO roomDTO);

    RoomDTO toDTO(Room room);

}
