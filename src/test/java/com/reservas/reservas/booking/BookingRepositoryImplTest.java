package com.reservas.reservas.booking;

import com.reservas.reservas.domain.model.Booking;
import com.reservas.reservas.domain.model.BookingStatus;
import com.reservas.reservas.infrastructure.adapters.persistence.*;
import com.reservas.reservas.infrastructure.adapters.persistence.entities.BookingEntity;
import com.reservas.reservas.infrastructure.adapters.persistence.entities.NotificationEntity;
import com.reservas.reservas.infrastructure.adapters.persistence.entities.SpaceEntity;
import com.reservas.reservas.infrastructure.adapters.persistence.entities.UserEntity;
import com.reservas.reservas.infrastructure.adapters.persistence.repositories.JpaBookingRepository;
import com.reservas.reservas.infrastructure.adapters.persistence.repositories.JpaNotificationRepository;
import com.reservas.reservas.infrastructure.adapters.persistence.repositories.JpaSpaceRepository;
import com.reservas.reservas.infrastructure.adapters.persistence.repositories.JpaUserRepository;
import com.reservas.reservas.infrastructure.mappers.BookingMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BookingRepositoryImplTest {

    @Mock
    private JpaBookingRepository jpaBookingRepository;
    @Mock private JpaUserRepository jpaUserRepository;
    @Mock private JpaSpaceRepository jpaSpaceRepository;
    @Mock private JpaNotificationRepository jpaNotificationRepository;

    @InjectMocks
    private BookingRepositoryImpl bookingRepository;

    @Test
    void shouldSaveNewBookingAndCreateNotification() {
        Long userId = 1L;
        Long spaceId = 2L;

        UserEntity user = new UserEntity();
        user.setId(userId);
        user.setName("Juan");
        user.setEmail("juan@mail.com");

        SpaceEntity space = new SpaceEntity();
        space.setId(spaceId);
        space.setName("Sala A");

        Booking booking = new Booking(
                null, // nuevo booking
                userId,
                spaceId,
                LocalDateTime.of(2025, 6, 14, 10, 0),
                LocalDateTime.of(2025, 6, 14, 12, 0),
                "Reunión semanal",
                LocalDateTime.now(),
                BookingStatus.CONFIRMADA
        );

        BookingEntity bookingEntity = BookingMapper.toEntity(booking, user, space);
        bookingEntity.setId(100L);
        bookingEntity.setCreationDate(LocalDateTime.now());

        Mockito.when(jpaUserRepository.findById(userId)).thenReturn(Optional.of(user));
        Mockito.when(jpaSpaceRepository.findById(spaceId)).thenReturn(Optional.of(space));
        Mockito.when(jpaBookingRepository.save(any())).thenReturn(bookingEntity);

        Booking saved = bookingRepository.save(booking);

        assertNotNull(saved);
        assertEquals(100L, saved.getId());
        assertEquals(BookingStatus.CONFIRMADA, saved.getBookingStatus());

        verify(jpaNotificationRepository).save(any(NotificationEntity.class));
    }
}