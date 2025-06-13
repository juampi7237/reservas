package com.reservas.reservas.domain.ports.in;

import com.reservas.reservas.domain.model.Notification;

import java.util.List;

public interface NotificationUseCase {
    Notification createdNotification(Long bookingId);
    Notification updatedNotification(Long bookingId);
    void saveNotification(Notification notificationDto);
    List<Notification> getAll();
}