package com.reservas.reservas.infrastructure.adapters.persistence.entities;

import com.reservas.reservas.domain.model.BookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String observaciones;
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;
    private LocalDateTime creationDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "space_id", nullable = false)
    private SpaceEntity space;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<NotificationEntity> notifications = new ArrayList<>();
}
