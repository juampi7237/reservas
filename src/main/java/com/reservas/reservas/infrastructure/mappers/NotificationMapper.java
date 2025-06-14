package com.reservas.reservas.infrastructure.mappers;

import com.reservas.reservas.domain.model.Notification;
import com.reservas.reservas.infrastructure.adapters.persistence.entities.NotificationEntity;

import java.util.List;
import java.util.stream.Collectors;

public class NotificationMapper {

    // Entity → Domain
    public static Notification toDomain(NotificationEntity entity) {
        if (entity == null) return null;

        return new Notification(
                entity.getId(),
                entity.getRecipientEmail(),
                entity.getSubject(),
                entity.getMessage(),
                entity.getSentAt(),
                entity.isSuccess()
        );
    }

    // Domain → Entity
    public static NotificationEntity toEntity(Notification model) {
        if (model == null) return null;

        NotificationEntity entity = new NotificationEntity();
        entity.setId(model.getId());
        entity.setRecipientEmail(model.getRecipientEmail());
        entity.setSubject(model.getSubject());
        entity.setMessage(model.getMessage());
        entity.setSentAt(model.getSentAt());
        entity.setSuccess(model.isSuccess());
        // Relaciones quedan nulas (puedes setearlas aparte si es necesario)
        return entity;
    }

    // List<Entity> → List<Domain>
    public static List<Notification> toDomainList(List<NotificationEntity> entities) {
        return entities == null ? List.of() :
                entities.stream()
                        .map(NotificationMapper::toDomain)
                        .collect(Collectors.toList());
    }

    // List<Domain> → List<Entity>
    public static List<NotificationEntity> toEntityList(List<Notification> models) {
        return models == null ? List.of() :
                models.stream()
                        .map(NotificationMapper::toEntity)
                        .collect(Collectors.toList());
    }
}