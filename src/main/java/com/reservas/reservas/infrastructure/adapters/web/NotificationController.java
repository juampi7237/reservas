package com.reservas.reservas.infrastructure.adapters.web;

import com.reservas.reservas.domain.model.Notification;
import com.reservas.reservas.domain.ports.in.NotificationUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notifications")
@AllArgsConstructor
public class NotificationController {

    private final NotificationUseCase notificationUseCase;
    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> notifications = notificationUseCase.getAll();
        return ResponseEntity.ok(notifications);
    }
}