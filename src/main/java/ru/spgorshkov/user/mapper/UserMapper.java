package ru.spgorshkov.user.mapper;

import org.mapstruct.Mapper;
import ru.spgorshkov.user.dto.User;
import ru.spgorshkov.user.entity.UserEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toDto(UserEntity entity);
    List<User> toDtoList(Iterable<UserEntity> entity);
    UserEntity toEntity(User dto);
}
