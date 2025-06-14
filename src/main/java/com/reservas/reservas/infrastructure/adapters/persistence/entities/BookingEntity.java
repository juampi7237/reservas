package com.reservas.reservas.infrastructure.adapters.persistence.entities;

import com.reservas.reservas.domain.model.BookingStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotNull(message = "La fecha y hora de inicio es obligatoria")
    private LocalDateTime startTime;

    @NotNull(message = "La fecha y hora de fin es obligatoria")
    private LocalDateTime endTime;

    @Size(max = 500, message = "Las observaciones no deben superar los 500 caracteres")
    private String observaciones;

    @NotNull(message = "El estado de la reserva es obligatorio")
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @PastOrPresent(message = "La fecha de creación no puede ser futura")
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
