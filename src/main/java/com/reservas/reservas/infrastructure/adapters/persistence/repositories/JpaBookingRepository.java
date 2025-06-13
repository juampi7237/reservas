package com.reservas.reservas.infrastructure.adapters.persistence.repositories;

import com.reservas.reservas.domain.model.SpaceType;
import com.reservas.reservas.infrastructure.adapters.persistence.entities.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface JpaBookingRepository extends JpaRepository<BookingEntity, Long> {

    @Query("SELECT b FROM BookingEntity b " +
            "WHERE b.startTime >= :startDate AND b.endTime <= :endDate " +
            "ORDER BY b.startTime ASC")
    List<BookingEntity> findBookingsByDateRange(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);

      @Query("SELECT b FROM BookingEntity b " +
            "WHERE CAST(b.startTime AS localdate) = CAST(:date AS localdate) " +
            "ORDER BY b.startTime ASC")
    List<BookingEntity> findBookingsByDate(@Param("date") LocalDate date);

    List<BookingEntity> findBySpace_Type(SpaceType type);
}
