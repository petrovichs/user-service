package ru.spgorshkov.user.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.spgorshkov.user.dao.UserRepository;
import ru.spgorshkov.user.dto.User;
import ru.spgorshkov.user.entity.UserEntity;
import ru.spgorshkov.user.mapper.UserMapper;
import ru.spgorshkov.user.service.UserService;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public void deleteUserById(Long uuid) {
        repository.deleteById(Math.toIntExact(uuid));
    }

    @Override
    public void addUser(User dto) {
        repository.save(mapper.toEntity(dto));
    }

    @Override
    public List<User> getAllUsers() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public User getUserById(Long id) {
        UserEntity entity = repository.findById(Math.toIntExact(id)).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return mapper.toDto(entity);
    }

    @Override
    public void updateUser(Long id, User dto) {
        if(dto.getId() == null) throw new IllegalArgumentException("ID is blank or null");

        UserEntity entity = repository.findById(Math.toIntExact(dto.getId())).orElseThrow(()->new IllegalArgumentException("User not found"));
        entity.setEmail(dto.getEmail());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPhone(dto.getPhone());
        entity.setUsername(dto.getUsername());
        repository.save(entity);
    }


}
