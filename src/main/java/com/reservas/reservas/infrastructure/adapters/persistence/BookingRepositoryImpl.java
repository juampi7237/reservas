package com.reservas.reservas.infrastructure.adapters.persistence;

import com.reservas.reservas.domain.model.Booking;
import com.reservas.reservas.domain.model.SpaceType;
import com.reservas.reservas.domain.ports.out.BookingRepositoryPort;
import com.reservas.reservas.infrastructure.adapters.persistence.entities.BookingEntity;
import com.reservas.reservas.infrastructure.adapters.persistence.entities.NotificationEntity;
import com.reservas.reservas.infrastructure.adapters.persistence.entities.SpaceEntity;
import com.reservas.reservas.infrastructure.adapters.persistence.entities.UserEntity;
import com.reservas.reservas.infrastructure.mappers.BookingMapper;
import com.reservas.reservas.infrastructure.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class BookingRepositoryImpl implements BookingRepositoryPort {

    private final JpaBookingRepository jpaBookingRepository;
    private final JpaUserRepository jpaUserRepository;
    private final JpaSpaceRepository jpaSpaceRepository;
    private final  JpaNotificationRepository jpaNotificationRepository;
    @Override
    public Booking save(Booking booking) {
        UserEntity user = jpaUserRepository.findById(booking.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + booking.getUserId()));

        SpaceEntity space = jpaSpaceRepository.findById(booking.getSpaceId())
                .orElseThrow(() -> new RuntimeException("Space not found with id: " + booking.getSpaceId()));

        boolean isNew = (booking.getId() == null) || !jpaBookingRepository.existsById(booking.getId());

        BookingEntity bookingEntity = BookingMapper.toEntity(booking, user, space);
        bookingEntity.setCreationDate(LocalDateTime.now());

        bookingEntity = jpaBookingRepository.save(bookingEntity);

        String subject = "";
        String message = "";
        if (isNew) {
            subject = "Nueva reserva creada";
            message = String.format(
                    "Hola %s. Se ha creado una nueva reserva para el espacio %s. Fecha: %s a %s",
                    user.getName(), space.getName(), booking.getStartTime(), booking.getEndTime()
            );
        } else {
            subject = "Reserva actualizada";
            message = String.format(
                    "Hola %s. Se ha actualizado tu reserva para el espacio %s. Nueva fecha: %s a %s",
                    user.getName(), space.getName(), booking.getStartTime(), booking.getEndTime()
            );
        }

        NotificationEntity notification = new NotificationEntity();
        notification.setRecipientEmail(user.getEmail());
        notification.setSubject(subject);
        notification.setMessage(message);
        notification.setSentAt(LocalDateTime.now());
        notification.setSuccess(true);
        notification.setUser(user);
        notification.setSpace(space);
        notification.setBooking(bookingEntity);

        jpaNotificationRepository.save(notification);

        return BookingMapper.toDomain(bookingEntity);
    }

    @Override
    public Optional<Booking> findById(Long id) {
        BookingEntity booking = jpaBookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
        return Optional.ofNullable(BookingMapper.toDomain(booking));
    }

    @Override
    public List<Booking> getAll() {
        return BookingMapper.toDomainList(jpaBookingRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        jpaBookingRepository.deleteById(id);
    }

    @Override
    public List<Booking> getBookingsByDate(LocalDate date) {
        return BookingMapper.toDomainList(jpaBookingRepository.findBookingsByDate(date));
    }

    @Override
    public List<Booking> getBookingsBySpaceType(String spaceType) {
        return BookingMapper.toDomainList(jpaBookingRepository.findBySpace_Type(SpaceType.valueOf(spaceType)));
    }

    @Override
    public List<Booking> getBookingsByDateRange(LocalDate startDate, LocalDate endDate) {
        return BookingMapper.toDomainList(jpaBookingRepository.findBookingsByDateRange(startDate.atStartOfDay(), endDate.atStartOfDay()));
    }
}