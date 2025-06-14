package com.reservas.reservas.domain.ports.out;

import com.reservas.reservas.domain.model.Booking;
import com.reservas.reservas.domain.model.SpaceType;
import com.reservas.reservas.domain.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookingRepositoryPort {
    Booking save(Booking booking);
    Optional<Booking> findById(Long id);
    List<Booking> getAll();
    void deleteById(Long id);
    List<Booking> getBookingsByDate(LocalDate date);
    List<Booking> getBookingsByDateRange(LocalDate startDate, LocalDate endDate);
    List<Booking> getBookingsBySpaceType(String spaceType);
}
