package com.cognizant.employeetraveldesk.reservations.service.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cognizant.employeetraveldesk.reservations.model.ReservationTypesDTO;
import com.cognizant.employeetraveldesk.reservations.model.mapper.ListModelMapper;
import com.cognizant.employeetraveldesk.reservations.repository.ReservationTypesRepository;
import com.cognizant.employeetraveldesk.reservations.service.ReservationTypesService;

public class ReservationTypesServiceImplTest {

    @InjectMocks
    private ReservationTypesServiceImpl reservationTypesService;

    @Mock
    private ReservationTypesRepository reservationTypesRepository;

    @Mock
    private ListModelMapper listModelMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetReservationTypes_ReturnsReservationTypesList() {
        // Arrange
        List<ReservationTypesDTO> expectedReservationTypes = new ArrayList<>();
        expectedReservationTypes.add(new ReservationTypesDTO(1, "Type 1"));
        expectedReservationTypes.add(new ReservationTypesDTO(2, "Type 2"));

        when(reservationTypesRepository.findAll()).thenReturn(new ArrayList<>());
        when(listModelMapper.reservationTypesEntityToDTO(mock(List.class))).thenReturn(expectedReservationTypes);

        // Act
        List<ReservationTypesDTO> actualReservationTypes = reservationTypesService.getReservationTypes();

        // Assert
        assertNotNull(actualReservationTypes);
//        assertEquals(expectedReservationTypes.size(), actualReservationTypes.size());
        assertEquals(expectedReservationTypes, actualReservationTypes);
    }
}

