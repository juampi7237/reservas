package com.reservas.reservas.infrastructure.adapters.persistence;

import com.reservas.reservas.infrastructure.adapters.persistence.entities.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaNotificationRepository extends JpaRepository<NotificationEntity,Long> {
}