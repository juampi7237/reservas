package com.reservas.reservas.infrastructure.adapters.persistence;

import com.reservas.reservas.infrastructure.adapters.persistence.entities.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBookingRepository extends JpaRepository<BookingEntity, Long> {
}
