package com.reservas.reservas.domain.ports.in;

import com.reservas.reservas.domain.model.User;

import java.util.List;

public interface UserUseCase {
    List<User> findAll();
    User createUser ( User user);
    User findById(Long id);
}
