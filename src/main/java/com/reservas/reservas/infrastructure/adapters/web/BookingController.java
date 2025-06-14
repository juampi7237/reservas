package com.reservas.reservas.infrastructure.adapters.web;

import com.reservas.reservas.domain.model.Booking;
import com.reservas.reservas.domain.ports.in.BookingUseCase;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/bookings")
@AllArgsConstructor
public class BookingController {

    private final BookingUseCase bookingUseCase;

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBooking() {
        List<Booking> booking = bookingUseCase.getAllBookings();
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long id) {
        Booking booking = bookingUseCase.findById(id);
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/date")
    public ResponseEntity<List<Booking>> getBookingsByDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Booking> responses = bookingUseCase.getBookingsByDate(date);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/type")
    public ResponseEntity<List<Booking>> getBookingsBySpaceType(
            @RequestParam String spaceType) {
        List<Booking> responses = bookingUseCase.getBookingsBySpaceType(spaceType);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<Booking>> getBookingsByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate endDate) {
        List<Booking> responses = bookingUseCase.getBookingsByDateRange(startDate, endDate);
        return ResponseEntity.ok(responses);
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking createdBooking = bookingUseCase.createBooking(booking);
        return ResponseEntity.ok(createdBooking);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateUser(@PathVariable Long id, @RequestBody Booking booking) {
        Booking updatedbooking = bookingUseCase.updateBooking(booking,id);
        return ResponseEntity.ok(updatedbooking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        bookingUseCase.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
