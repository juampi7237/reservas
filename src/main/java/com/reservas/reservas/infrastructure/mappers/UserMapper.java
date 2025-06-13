package com.reservas.reservas.infrastructure.mappers;

import com.reservas.reservas.domain.model.User;
import com.reservas.reservas.infrastructure.adapters.persistence.entities.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    // De Entity a Domain
    public static User toDomain(UserEntity entity) {
        if (entity == null) return null;
        User user = new User(entity.getName(), entity.getEmail(), entity.getPhone());
        user.setId(entity.getId());
        user.setAdmin(entity.isAdmin());
        user.setRegisterDate(entity.getRegisterDate());
        return user;
    }

    // De Domain a Entity
    public static UserEntity toEntity(User domain) {
        if (domain == null) return null;
        UserEntity entity = new UserEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setEmail(domain.getEmail());
        entity.setPhone(domain.getPhone());
        entity.setAdmin(domain.isAdmin());
        entity.setRegisterDate(domain.getRegisterDate());
        return entity;
    }

    // Lista de Entity a Domain
    public static List<User> toDomainList(List<UserEntity> entities) {
        return entities.stream()
                .map(UserMapper::toDomain)
                .collect(Collectors.toList());
    }

    // Lista de Domain a Entity
    public static List<UserEntity> toEntityList(List<User> domains) {
        return domains.stream()
                .map(UserMapper::toEntity)
                .collect(Collectors.toList());
    }
}
