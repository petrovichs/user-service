package ru.spgorshkov.user.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.spgorshkov.user.entity.UserEntity;

import java.util.UUID;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, UUID> {
    UserEntity findByUuid(UUID uuid);
}
