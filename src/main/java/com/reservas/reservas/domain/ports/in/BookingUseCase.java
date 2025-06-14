package com.reservas.reservas.domain.ports.in;

import com.reservas.reservas.domain.model.Booking;
import com.reservas.reservas.domain.model.SpaceType;
import com.reservas.reservas.domain.model.User;

import java.time.LocalDate;
import java.util.List;

public interface BookingUseCase {
    List<Booking> getAllBookings();
    Booking createBooking ( Booking booking);
    Booking findById(Long id);
    Booking updateBooking ( Booking booking, Long id);
    void deleteBooking(Long id);
    List<Booking> getBookingsByDate(LocalDate date);
    List<Booking> getBookingsBySpaceType(String spaceType);
    List<Booking> getBookingsByDateRange(LocalDate startDate, LocalDate endDate);
}
