package ru.spgorshkov.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.spgorshkov.user.dto.User;
import ru.spgorshkov.user.server.UserApi;
import ru.spgorshkov.user.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    @Autowired
    UserService userService;

    @GetMapping(value = {"/users"}, produces = {"application/json"})
    public ResponseEntity<List<User>> getAllUserByUuid() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping(value = {"/health"})
    public ResponseEntity<String> getHealth() {
        log.debug("check health");
        return ResponseEntity.ok("{\"status\": \"OK\"}");
    }

    @GetMapping(value = {"/"})
    public ResponseEntity<String> getRoot() {
        log.debug("check root");
        return ResponseEntity.ok("check root. I'm ROOT, I'm OK ");
    }

    @Override
    public ResponseEntity<Void> createUser(@Valid User user) {
        log.debug("add user {}", user);
        userService.addUser(user);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long userId) {
        log.debug("delete user by id {}", userId);
        userService.deleteUserById(userId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<User> findUserById(Long userId) {
        log.debug("get user by uuid {}", userId);
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @Override
    public ResponseEntity<Void> updateUser(Long userId, @Valid User user) {
        log.debug("update user {}", userId);
        userService.updateUser(userId, user);
        return ResponseEntity.ok().build();
    }
}
