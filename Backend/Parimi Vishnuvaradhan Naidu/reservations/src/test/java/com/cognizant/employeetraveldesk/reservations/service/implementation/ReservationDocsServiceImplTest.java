package com.cognizant.employeetraveldesk.reservations.service.implementation;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cognizant.employeetraveldesk.reservations.entity.ReservationDocs;
import com.cognizant.employeetraveldesk.reservations.entity.Reservations;
import com.cognizant.employeetraveldesk.reservations.model.ReservationDocsDTO;
import com.cognizant.employeetraveldesk.reservations.model.mapper.ModelMapper;
import com.cognizant.employeetraveldesk.reservations.repository.ReservationDocsRepository;
import com.cognizant.employeetraveldesk.reservations.repository.ReservationsRepository;
import com.cognizant.employeetraveldesk.reservations.service.ReservationDocsService;

public class ReservationDocsServiceImplTest {

    @InjectMocks
    private ReservationDocsServiceImpl reservationDocsService;

    @Mock
    private ReservationDocsRepository reservationDocsRepository;

    @Mock
    private ReservationsRepository reservationsRepository;

    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetReservationDocsById_WithExistingReservationId_ReturnsReservationDocsDTO() {
        // Arrange
        int reservationId = 1;
        Reservations reservation = new Reservations();
        reservation.setId(reservationId);

        ReservationDocs reservationDocs = new ReservationDocs();
        reservationDocs.setId(1);
        reservationDocs.setReservation(reservation);

        ReservationDocsDTO expectedDocsDTO = new ReservationDocsDTO(reservationId, null, null);
        expectedDocsDTO.setId(1);

        when(reservationsRepository.findById(reservationId)).thenReturn(Optional.of(reservation));
        when(reservationDocsRepository.findByReservationid(reservation)).thenReturn(reservationDocs);
        when(modelMapper.reservationDocsEntityToDTO(reservationDocs)).thenReturn(expectedDocsDTO);

        // Act
        ReservationDocsDTO actualDocsDTO = reservationDocsService.getReservationDocsById(reservationId);

        // Assert
        assertNotNull(actualDocsDTO);
        assertEquals(expectedDocsDTO.getId(), actualDocsDTO.getId());
    }

    @Test
    public void testGetReservationDocsById_WithNonExistingReservationId_ReturnsNull() {
        // Arrange
        int reservationId = 1;
        when(reservationsRepository.findById(reservationId)).thenReturn(Optional.empty());

        // Act
        ReservationDocsDTO actualDocsDTO = reservationDocsService.getReservationDocsById(reservationId);

        // Assert
        assertNull(actualDocsDTO);
    }

    @Test
    public void testGetReservationDocsById_WithExistingReservationIdButNoDocs_ReturnsNull() {
        // Arrange
        int reservationId = 1;
        Reservations reservation = new Reservations();
        reservation.setId(reservationId);

        when(reservationsRepository.findById(reservationId)).thenReturn(Optional.of(reservation));
        when(reservationDocsRepository.findByReservationid(reservation)).thenReturn(null);

        // Act
        ReservationDocsDTO actualDocsDTO = reservationDocsService.getReservationDocsById(reservationId);

        // Assert
        assertNull(actualDocsDTO);
    }
}

