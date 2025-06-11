package com.reservas.reservas.infrastructure.adapters.persistence;

import com.reservas.reservas.infrastructure.adapters.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
