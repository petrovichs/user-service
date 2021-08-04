package ru.spgorshkov.user.mapper;

import org.mapstruct.Mapper;
import ru.spgorshkov.user.dto.UserDto;
import ru.spgorshkov.user.entity.UserEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(UserEntity entity);
    List<UserDto> toDtoList(Iterable<UserEntity> entity);
    UserEntity toEntity(UserDto dto);
}
