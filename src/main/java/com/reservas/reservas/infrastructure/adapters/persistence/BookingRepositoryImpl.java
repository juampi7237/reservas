package com.reservas.reservas.infrastructure.adapters.persistence;

import com.reservas.reservas.domain.model.Booking;
import com.reservas.reservas.domain.ports.out.BookingRepositoryPort;
import com.reservas.reservas.infrastructure.adapters.persistence.entities.BookingEntity;
import com.reservas.reservas.infrastructure.adapters.persistence.entities.SpaceEntity;
import com.reservas.reservas.infrastructure.adapters.persistence.entities.UserEntity;
import com.reservas.reservas.infrastructure.mappers.BookingMapper;
import com.reservas.reservas.infrastructure.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class BookingRepositoryImpl implements BookingRepositoryPort {

    private final JpaBookingRepository jpaBookingRepository;
    private final JpaUserRepository jpaUserRepository;
    private final JpaSpaceRepository jpaSpaceRepository;
    @Override
    public Booking save(Booking booking) {
        UserEntity user = jpaUserRepository.findById(booking.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + booking.getUserId()));
        SpaceEntity space = jpaSpaceRepository.findById(booking.getUserId())
                .orElseThrow(() -> new RuntimeException("Space not found with id: " + booking.getUserId()));
        BookingEntity bookingEntity = BookingMapper.toEntity(booking,user,space);
        bookingEntity.setCreationDate(LocalDateTime.now());
        return BookingMapper.toDomain(jpaBookingRepository.save(bookingEntity));
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
}
