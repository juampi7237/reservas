package com.reservas.reservas.domain.ports.in;

import com.reservas.reservas.domain.model.User;

import java.util.List;

public interface UserUseCase {
    List<User> getAllUsers();
    User createUser ( User user);
    User findById(Long id);
    User updateUser ( User user, Long id);
    void deleteUser(Long id);
    User findByEmail(String email);
}
