package ru.spgorshkov.user.service;

import ru.spgorshkov.user.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserDto> getAllUsers();

    void addUser(UserDto dto);

    UserDto getUserByUuid(UUID uuid);

    void deleteUserByUuid(UUID uuid);

    void updateUser(UserDto dto);
}
