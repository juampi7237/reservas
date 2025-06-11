package com.reservas.reservas.application.services;

import com.reservas.reservas.domain.model.User;
import com.reservas.reservas.domain.ports.in.UserUseCase;
import com.reservas.reservas.domain.ports.out.UserRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class UserService implements UserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    @Override
    public List<User> findAll() {
        return userRepositoryPort.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepositoryPort.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User createUser(User user) {
        return userRepositoryPort.save(user);
    }


}
