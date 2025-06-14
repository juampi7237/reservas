package com.reservas.reservas.infrastructure.adapters.persistence;

import com.reservas.reservas.domain.model.Space;
import com.reservas.reservas.domain.model.User;
import com.reservas.reservas.domain.ports.out.SpaceRepositoryPort;
import com.reservas.reservas.infrastructure.adapters.persistence.entities.SpaceEntity;
import com.reservas.reservas.infrastructure.adapters.persistence.repositories.JpaSpaceRepository;
import com.reservas.reservas.infrastructure.mappers.SpaceMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class SpaceRepositoryImpl implements SpaceRepositoryPort {


    private final JpaSpaceRepository jpaSpaceRepository;

    @Override
    public List<Space> getAll() {
        return SpaceMapper.toDomainList(jpaSpaceRepository.findAll());
    }

    @Override
    public Space save(Space space) {
        SpaceEntity entity = SpaceMapper.toEntity(space);
        return SpaceMapper.toDomain(jpaSpaceRepository.save(entity));
    }

    @Override
    public Optional<Space> findById(Long id) {
        SpaceEntity space = jpaSpaceRepository.findById(id).orElseThrow(() -> new RuntimeException("Space not found"));
        return Optional.ofNullable(SpaceMapper.toDomain(space));
    }

    @Override
    public void deleteById(Long id) {
        jpaSpaceRepository.deleteById(id);
    }

    @Override
    public User update(Long id, Space user) {
        return null;
    }
}
