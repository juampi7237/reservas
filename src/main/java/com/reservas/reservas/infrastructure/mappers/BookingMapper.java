package com.reservas.reservas.infrastructure.mappers;

import com.reservas.reservas.domain.model.Booking;
import com.reservas.reservas.infrastructure.adapters.persistence.entities.BookingEntity;
import com.reservas.reservas.infrastructure.adapters.persistence.entities.SpaceEntity;
import com.reservas.reservas.infrastructure.adapters.persistence.entities.UserEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class BookingMapper {

    // De BookingEntity a Booking (dominio)
    public static Booking toDomain(BookingEntity entity) {
        if (entity == null) return null;
        return new Booking(
                entity.getId(),
                entity.getUser().getId(),
                entity.getSpace().getId(),
                entity.getStartTime(),
                entity.getEndTime(),
                entity.getObservaciones(),
                entity.getCreationDate(),
                entity.getBookingStatus()

        );
    }

    public static BookingEntity toEntity(Booking domain, UserEntity user, SpaceEntity space) {
        if (domain == null) return null;
        BookingEntity entity = new BookingEntity();
        entity.setId(domain.getId());
        entity.setUser(user);
        entity.setSpace(space);
        entity.setStartTime(domain.getStartTime());
        entity.setEndTime(domain.getEndTime());
        entity.setObservaciones(domain.getObservaciones());
        entity.setCreationDate(domain.getCreationDate());
        entity.setBookingStatus(domain.getBookingStatus());
        return entity;
    }

    // Lista de BookingEntity a Booking
    public static List<Booking> toDomainList(List<BookingEntity> entities) {
        return entities.stream()
                .map(BookingMapper::toDomain)
                .collect(Collectors.toList());
    }
}
