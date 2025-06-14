package com.reservas.reservas.application.services;

import com.reservas.reservas.domain.model.Booking;
import com.reservas.reservas.domain.model.SpaceType;
import com.reservas.reservas.domain.ports.in.BookingUseCase;
import com.reservas.reservas.domain.ports.out.BookingRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService implements BookingUseCase {

    private final BookingRepositoryPort bookingRepositoryPort;
    @Override
    public List<Booking> getAllBookings() {
        return bookingRepositoryPort.getAll();
    }

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepositoryPort.save(booking);
    }

    @Override
    public Booking findById(Long id) {
        return bookingRepositoryPort.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    @Override
    public Booking updateBooking(Booking booking, Long id) {
        Booking existingBooking = findById(id);
        existingBooking.setBookingStatus(booking.getBookingStatus());
        existingBooking.setObservaciones(booking.getObservaciones());
        existingBooking.setStartTime(booking.getStartTime());
        existingBooking.setEndTime(booking.getEndTime());
        return bookingRepositoryPort.save(existingBooking);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepositoryPort.deleteById(id);
    }

    @Override
    public List<Booking> getBookingsByDate(LocalDate date) {
        return bookingRepositoryPort.getBookingsByDate(date);
    }

    @Override
    public List<Booking> getBookingsBySpaceType(String spaceType) {
        return bookingRepositoryPort.getBookingsBySpaceType(spaceType);
    }

    @Override
    public List<Booking> getBookingsByDateRange(LocalDate startDate, LocalDate endDate) {
        return bookingRepositoryPort.getBookingsByDateRange(startDate,endDate);
    }
}
