package com.reservas.reservas.infrastructure.adapters.persistence.entities;

import com.reservas.reservas.domain.model.SpaceType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "spaces")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre del espacio es obligatorio")
    private String name;

    @Size(max = 500, message = "La descripción no debe superar los 500 caracteres")
    private String description;

    @Min(value = 1, message = "La capacidad debe ser mayor a 0")
    private int capacity;

    @NotNull(message = "El tipo de espacio es obligatorio")
    @Enumerated(EnumType.STRING)
    private SpaceType type;
    private boolean isActive;

    @OneToMany(mappedBy = "space", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BookingEntity> bookings = new ArrayList<>();

    @OneToMany(mappedBy = "space", cascade = CascadeType.ALL)
    private List<NotificationEntity> notifications = new ArrayList<>();
}
