package com.reservas.reservas.application.services;

import com.reservas.reservas.domain.model.Notification;
import com.reservas.reservas.domain.ports.in.NotificationUseCase;
import com.reservas.reservas.domain.ports.out.NotificationRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService implements NotificationUseCase {

    private final NotificationRepositoryPort notificationRepositoryPort;

    @Override
    public List<Notification> getAll() {
        return notificationRepositoryPort.getAll();
    }

    @Override
    public Notification createdNotification(Long bookingId) {
        return null;
    }

    @Override
    public Notification updatedNotification(Long bookingId) {
        return null;
    }

    @Override
    public void saveNotification(Notification notification) {
        notificationRepositoryPort.save(notification);
    }
}