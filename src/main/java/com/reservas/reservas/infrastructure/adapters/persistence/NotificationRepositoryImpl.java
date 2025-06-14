package com.reservas.reservas.infrastructure.adapters.persistence;

import com.reservas.reservas.domain.model.Notification;
import com.reservas.reservas.domain.ports.out.NotificationRepositoryPort;
import com.reservas.reservas.infrastructure.adapters.persistence.entities.NotificationEntity;
import com.reservas.reservas.infrastructure.adapters.persistence.repositories.JpaNotificationRepository;
import com.reservas.reservas.infrastructure.mappers.NotificationMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@AllArgsConstructor
public class NotificationRepositoryImpl implements NotificationRepositoryPort {

    private final JpaNotificationRepository jpaNotificationRepository;
    @Override
    public Notification save(Notification notification) {
        NotificationEntity notificationEntity = NotificationMapper.toEntity(notification);
        return NotificationMapper.toDomain(jpaNotificationRepository.save(notificationEntity));
    }

    @Override
    public List<Notification> getAll() {
        return NotificationMapper.toDomainList(jpaNotificationRepository.findAll());
    }
}