package com.reservas.reservas.domain.ports.in;

import com.reservas.reservas.domain.model.Booking;
import com.reservas.reservas.domain.model.User;

import java.util.List;

public interface BookingUseCase {
    List<Booking> getAllBookings();
    Booking createBooking ( Booking booking);
    Booking findById(Long id);
    Booking updateBooking ( Booking booking, Long id);
    void deleteBooking(Long id);
}
