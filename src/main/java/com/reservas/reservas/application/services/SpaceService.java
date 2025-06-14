package com.reservas.reservas.application.services;

import com.reservas.reservas.domain.model.Space;
import com.reservas.reservas.domain.ports.in.SpaceUseCase;
import com.reservas.reservas.domain.ports.out.SpaceRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpaceService implements SpaceUseCase {

    private final SpaceRepositoryPort spaceRepositoryPort;

    @Override
    public List<Space> getAllSpaces() {
        return spaceRepositoryPort.getAll();
    }

    @Override
    public Space createSpace(Space space) {
        return spaceRepositoryPort.save(space);
    }

    @Override
    public Space findById(Long id) {
        return spaceRepositoryPort.findById(id).orElseThrow(() -> new RuntimeException("Space not found"));
    }

    @Override
    public Space updateSpace(Space space, Long id) {
        Space existingSpace = findById(id);
        existingSpace.setName(space.getName());
        existingSpace.setCapacity(space.getCapacity());
        existingSpace.setDescription(space.getDescription());
        existingSpace.setType(space.getType());
        return spaceRepositoryPort.save(existingSpace);
    }

    @Override
    public void deleteSpace(Long id) {
        spaceRepositoryPort.deleteById(id);
    }
}
