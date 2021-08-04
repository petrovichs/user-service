package ru.spgorshkov.user.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.spgorshkov.user.dao.UserRepository;
import ru.spgorshkov.user.dto.UserDto;
import ru.spgorshkov.user.entity.UserEntity;
import ru.spgorshkov.user.mapper.UserMapper;
import ru.spgorshkov.user.service.UserService;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public List<UserDto> getAllUsers() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public UserDto getUserByUuid(UUID uuid) {
        return mapper.toDto(repository.findByUuid(uuid));
    }

    @Override
    public void deleteUserByUuid(UUID uuid) {
        repository.deleteById(uuid);
    }

    @Override
    public void updateUser(UserDto dto) {
        if(dto.getUuid() == null) throw new IllegalArgumentException("UUID is blank or null");
        UserEntity entity = repository.findByUuid(dto.getUuid());
        entity.setEmail(dto.getEmail());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPhone(dto.getPhone());
        entity.setUsername(dto.getUsername());
        repository.save(entity);
    }


    @Override
    public void addUser(UserDto dto) {
        repository.save(mapper.toEntity(dto));
    }
}
