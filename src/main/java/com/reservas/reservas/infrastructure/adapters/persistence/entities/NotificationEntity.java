package com.reservas.reservas.infrastructure.adapters.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String recipientEmail;
    private String subject;
    private String message;
    private LocalDateTime sentAt;
    private boolean isSuccess;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "space_id")
    private SpaceEntity space;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private BookingEntity booking;
}
