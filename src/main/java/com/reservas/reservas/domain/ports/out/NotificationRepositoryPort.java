package com.reservas.reservas.domain.ports.out;

import com.reservas.reservas.domain.model.Notification;

import java.util.List;

public interface NotificationRepositoryPort {
    Notification save(Notification user);
    List<Notification> getAll();
}