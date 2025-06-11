package com.reservas.reservas.infrastructure.adapters.persistence;

import com.reservas.reservas.infrastructure.adapters.persistence.entities.SpaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSpaceRepository extends JpaRepository<SpaceEntity,Long> {
}
