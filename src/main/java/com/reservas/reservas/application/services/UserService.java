package com.reservas.reservas.application.services;

import com.reservas.reservas.domain.model.User;
import com.reservas.reservas.domain.ports.in.UserUseCase;
import com.reservas.reservas.domain.ports.out.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService implements UserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    @Override
    public List<User> getAllUsers() {
        return userRepositoryPort.getAll();
    }

    @Override
    public User findById(Long id) {
        return userRepositoryPort.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User createUser(User user) {
        return userRepositoryPort.save(user);
    }

    @Override
    public User updateUser(User user, Long id) {
        User existingUser = findById(id);
        existingUser.setEmail(user.getEmail());
        existingUser.setName(user.getName());
        existingUser.setPhone(user.getPhone());
        return userRepositoryPort.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepositoryPort.deleteById(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepositoryPort.findByEmail(email).orElseThrow(()->new RuntimeException("Email not foud"));
    }
}
