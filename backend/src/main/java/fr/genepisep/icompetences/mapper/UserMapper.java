package fr.genepisep.icompetences.mapper;


import fr.genepisep.icompetences.dto.UserDto;
import fr.genepisep.icompetences.entities.dao.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static UserDto toDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setName(userEntity.getName());
        userDto.setEmail(userEntity.getEmail());
        userDto.setIsepId(userEntity.getIsepId());
        userDto.setFirstname(userEntity.getFirstname());
        userDto.setDisableDate(userEntity.getDisableDate());
        return userDto;
    }

    public static List<UserDto> toDtoList(List<UserEntity> userEntities) {
        List<UserDto> dtos = new ArrayList<>();
        for (UserEntity entity : userEntities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }
}
