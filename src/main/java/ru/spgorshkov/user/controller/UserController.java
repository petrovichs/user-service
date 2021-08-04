package ru.spgorshkov.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.spgorshkov.user.dto.UserDto;
import ru.spgorshkov.user.service.UserService;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping(value = {"/backend/person/user"}, produces = {"application/json"})
    public ResponseEntity<Void> createUser(UserDto dto) {
        log.debug("add user {}", dto);
        userService.addUser(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = {"/backend/person/user/{uuid}"}, produces = {"application/json"})
    public ResponseEntity<UserDto> getUserByUuid(@PathVariable UUID uuid) {
        log.debug("get user by uuid {}", uuid);
        return ResponseEntity.ok(userService.getUserByUuid(uuid));
    }

    @PutMapping(value = {"/backend/person/user"}, produces = {"application/json"})
    public ResponseEntity<UserDto> updateUser(UserDto dto) {
        log.debug("update user {}", dto);
        userService.updateUser(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = {"/backend/person/user/{uuid}"}, produces = {"application/json"})
    public ResponseEntity<UserDto> deleteUser(@PathVariable UUID uuid) {
        log.debug("delete user by uuid {}", uuid);
        userService.deleteUserByUuid(uuid);
        return ResponseEntity.ok().build();
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





}
