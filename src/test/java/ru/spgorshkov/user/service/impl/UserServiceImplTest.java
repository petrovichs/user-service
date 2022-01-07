package ru.spgorshkov.user.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.spgorshkov.user.dao.UserRepository;
import ru.spgorshkov.user.dto.User;
import ru.spgorshkov.user.entity.UserEntity;
import ru.spgorshkov.user.mapper.UserMapper;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository repository;

    @Mock
    UserMapper mapper;

    UserEntity entity;

    User dto;

    @BeforeEach
    void before() {
        entity = UserEntity.builder()
                .username("Ivan")
                .build();
        dto = new User();
        dto.setUsername("Ivan");
        dto.setId(1L);
    }

    @Test
    void getAllUser() {
        when(repository.findAll()).thenReturn(Collections.singleton(entity));
        when(mapper.toDtoList(any())).thenReturn(Collections.singletonList(dto));
        List<User> allCountries = userService.getAllUsers();
        assertEquals(1, allCountries.size());
    }


}
