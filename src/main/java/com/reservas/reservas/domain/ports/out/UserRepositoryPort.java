package com.reservas.reservas.domain.ports.out;

import com.reservas.reservas.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {

    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    List<User> getAll();
    void deleteById(Long id);
    User update(Long id,User user);
}
