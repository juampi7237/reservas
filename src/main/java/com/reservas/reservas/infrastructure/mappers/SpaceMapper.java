package com.reservas.reservas.infrastructure.mappers;

import com.reservas.reservas.domain.model.Space;
import com.reservas.reservas.infrastructure.adapters.persistence.entities.SpaceEntity;

import java.util.List;
import java.util.stream.Collectors;

public class SpaceMapper {

    public static Space toDomain(SpaceEntity entity) {
        if (entity == null) return null;
        Space space = new Space(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getCapacity(),
                entity.getType()
        );
        return space;
    }

    public static SpaceEntity toEntity(Space domain) {
        if (domain == null) return null;
        SpaceEntity entity = new SpaceEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setDescription(domain.getDescription());
        entity.setCapacity(domain.getCapacity());
        entity.setType(domain.getType());
        entity.setActive(domain.isActive());
        return entity;
    }

    public static List<Space> toDomainList(List<SpaceEntity> entities) {
        return entities.stream()
                .map(SpaceMapper::toDomain)
                .collect(Collectors.toList());
    }

    public static List<SpaceEntity> toEntityList(List<Space> domains) {
        return domains.stream()
                .map(SpaceMapper::toEntity)
                .collect(Collectors.toList());
    }
}