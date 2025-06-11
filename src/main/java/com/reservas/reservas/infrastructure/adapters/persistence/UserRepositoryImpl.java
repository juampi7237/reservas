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

    private final UserRepository userRepository;


    @Override
    public User save(User user) {
        UserEntity userEntity = new UserEntity(user.getId(),user.getName(),user.getEmail(),user.getPhone(),user.isAdmin(),user.getRegisterDate(),null,null);
        UserEntity savedUser = userRepository.save(userEntity);
        return new User(savedUser.getName(), savedUser.getEmail(), savedUser.getPhone());
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return UserMapper.toDomainList(userRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public User update(Long id, User user) {
        return null;
    }
}
