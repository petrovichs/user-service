package ru.spgorshkov.user.service;

import ru.spgorshkov.user.dto.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void addUser(User dto);

    User getUserById(Long id);

    void deleteUserById(Long id);

    void updateUser(Long id, User dto);
}
