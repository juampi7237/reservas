package com.reservas.reservas.domain.ports.in;

import com.reservas.reservas.domain.model.Space;

import java.util.List;

public interface SpaceUseCase {
    List<Space> getAllSpaces();
    Space createSpace ( Space user);
    Space findById(Long id);
    Space updateSpace ( Space user, Long id);
    void deleteSpace(Long id);
}
