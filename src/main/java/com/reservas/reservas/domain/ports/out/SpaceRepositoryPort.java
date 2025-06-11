package com.reservas.reservas.domain.ports.out;

import com.reservas.reservas.domain.model.Space;
import com.reservas.reservas.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface SpaceRepositoryPort {
    Space save(Space user);
    Optional<Space> findById(Long id);
    List<Space> getAll();
    void deleteById(Long id);
    User update(Long id,Space user);
}
