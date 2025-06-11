package com.reservas.reservas.infrastructure.adapters.persistence;

import com.reservas.reservas.domain.model.User;
import com.reservas.reservas.domain.ports.out.UserRepositoryPort;
import com.reservas.reservas.infrastructure.adapters.persistence.entities.UserEntity;
import com.reservas.reservas.infrastructure.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepositoryPort {

    private final JpaUserRepository userRepository;

    @Override
    public List<User> getAll() {
        return UserMapper.toDomainList(userRepository.findAll());
    }

    @Override
    public User save(User user) {
        UserEntity entity = UserMapper.toEntity(user);
        return UserMapper.toDomain(userRepository.save(entity));
    }

    @Override
    public Optional<User> findById(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return Optional.ofNullable(UserMapper.toDomain(user));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Email not found"));
        return Optional.ofNullable(UserMapper.toDomain(user));
    }



    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(Long id, User user) {
        return null;
    }
}
