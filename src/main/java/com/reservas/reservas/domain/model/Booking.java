package com.reservas.reservas.domain.model;

import java.time.LocalDateTime;

public class Booking {
    private Long id;
    private Long userId;
    private Long spaceId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String observaciones;
    private BookingStatus bookingStatus;
    private LocalDateTime creationDate;

    public Booking(Long id, Long userId, Long spaceId, LocalDateTime startTime, LocalDateTime endTime, String observaciones, LocalDateTime creationDate) {

        this.id = id;
        this.userId = userId;
        this.spaceId = spaceId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.observaciones = observaciones;
        this.creationDate = creationDate;
        this.bookingStatus = BookingStatus.PENDIENTE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Long spaceId) {
        this.spaceId = spaceId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
