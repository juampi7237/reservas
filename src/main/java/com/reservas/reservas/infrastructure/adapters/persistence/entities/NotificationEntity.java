package com.reservas.reservas.infrastructure.adapters.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    @NotBlank(message = "El correo del destinatario es obligatorio")
    @Email(message = "Debe ser un correo válido")
    private String recipientEmail;

    @NotBlank(message = "El asunto no puede estar vacío")
    @Size(max = 200, message = "El asunto no debe superar los 200 caracteres")
    private String subject;

    @NotBlank(message = "El mensaje no puede estar vacío")
    @Size(max = 1000, message = "El mensaje no debe superar los 1000 caracteres")
    private String message;

    @PastOrPresent(message = "La fecha de envío no puede ser futura")
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
