package com.cognizant.employeetraveldesk.reservations.service.implementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.cognizant.employeetraveldesk.reservations.entity.Reservations;
import com.cognizant.employeetraveldesk.reservations.exception.DuplicateResourceException;
import com.cognizant.employeetraveldesk.reservations.exception.InvalidResourceException;
import com.cognizant.employeetraveldesk.reservations.exception.ResourceNotFoundException;
import com.cognizant.employeetraveldesk.reservations.model.ReservationsDTO;
import com.cognizant.employeetraveldesk.reservations.model.ReservationTypesDTO;
import com.cognizant.employeetraveldesk.reservations.model.mapper.ListModelMapper;
import com.cognizant.employeetraveldesk.reservations.model.mapper.ModelMapper;
import com.cognizant.employeetraveldesk.reservations.repository.ReservationsRepository;
import com.cognizant.employeetraveldesk.reservations.service.implementation.ReservationsServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ReservationsServiceImplTest {

    @Mock
    private ReservationsRepository reservationsRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private ListModelMapper listModelMapper;

    @InjectMocks
    private ReservationsServiceImpl reservationsService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddReservation_Success() throws DuplicateResourceException, InvalidResourceException {
        // Arrange
        ReservationsDTO reservationsDTO = new ReservationsDTO(null, 0, 0, null, null, null, null, 0, null, null);
        reservationsDTO.setId(1);
        reservationsDTO.setReservationDate(LocalDate.now());
        ReservationTypesDTO reservationTypesDTO = new ReservationTypesDTO(null, null);
        reservationTypesDTO.setTypeName("train");
        reservationsDTO.setReservationTypesDTO(reservationTypesDTO);

        Reservations reservationsEntity = new Reservations();
        reservationsEntity.setId(1);

        when(reservationsRepository.findById(1)).thenReturn(Optional.empty());
        when(modelMapper.reservationsDTOToEntity(reservationsDTO)).thenReturn(reservationsEntity);

        // Act
        boolean result = reservationsService.addReservation(reservationsDTO);

        // Assert
        assertTrue(result);
        verify(reservationsRepository).save(reservationsEntity);
    }

    @Test(expected = DuplicateResourceException.class)
    public void testAddReservation_DuplicateResourceException() throws DuplicateResourceException, InvalidResourceException {
        // Arrange
        ReservationsDTO reservationsDTO = new ReservationsDTO(null, 0, 0, null, null, null, null, 0, null, null);
        reservationsDTO.setId(1);

        Reservations existingReservation = new Reservations();
        existingReservation.setId(1);

        when(reservationsRepository.findById(1)).thenReturn(Optional.of(existingReservation));

        // Act
        reservationsService.addReservation(reservationsDTO);

        // Exception expected: DuplicateResourceException
    }

    @Test(expected = InvalidResourceException.class)
    public void testAddReservation_InvalidResourceException() throws DuplicateResourceException, InvalidResourceException {
        // Arrange
        ReservationsDTO reservationsDTO = new ReservationsDTO(null, 0, 0, null, null, null, null, 0, null, null);
        reservationsDTO.setId(1);
        reservationsDTO.setReservationDate(LocalDate.now().plusDays(1)); // Reservation date after travel planner date
        ReservationTypesDTO reservationTypesDTO = new ReservationTypesDTO(null, null);
        reservationTypesDTO.setTypeName("train");
        reservationsDTO.setReservationTypesDTO(reservationTypesDTO);

        // Act
        reservationsService.addReservation(reservationsDTO);

        // Exception expected: InvalidResourceException
    }

    @Test
    public void testGetReservationById_Success() throws ResourceNotFoundException {
        // Arrange
        int reservationId = 1;
        ReservationsDTO expectedReservationDTO = new ReservationsDTO(reservationId, reservationId, reservationId, null, null, null, null, reservationId, null, null);
        expectedReservationDTO.setId(reservationId);

        Reservations existingReservation = new Reservations();
        existingReservation.setId(reservationId);

        when(reservationsRepository.findById(reservationId)).thenReturn(Optional.of(existingReservation));
        when(modelMapper.reservationsEntityToDTO(existingReservation)).thenReturn(expectedReservationDTO);

        // Act
        ReservationsDTO result = reservationsService.getReservationById(reservationId);

        // Assert
        assertEquals(expectedReservationDTO, result);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetReservationById_ResourceNotFoundException() throws ResourceNotFoundException {
        // Arrange
        int reservationId = 1;

        when(reservationsRepository.findById(reservationId)).thenReturn(Optional.empty());

        // Act
        reservationsService.getReservationById(reservationId);

        // Exception expected: ResourceNotFoundException
    }

    @Test
    public void testGetAllReservationsByTravelRequestId_Success() throws ResourceNotFoundException {
        // Arrange
        int travelRequestId = 1;
        List<Reservations> existingReservations = new ArrayList<>();
        existingReservations.add(new Reservations());

        List<ReservationsDTO> expectedReservationDTOs = new ArrayList<>();
        expectedReservationDTOs.add(new ReservationsDTO(travelRequestId, travelRequestId, travelRequestId, null, null, null, null, travelRequestId, null, null));

        when(reservationsRepository.findAllByTravelRequestId(travelRequestId)).thenReturn(existingReservations);
        when(listModelMapper.reservationsEntityToDTO(existingReservations)).thenReturn(expectedReservationDTOs);

        // Act
        List<ReservationsDTO> result = reservationsService.getAllReservationsByTravelRequestId(travelRequestId);

        // Assert
        assertEquals(expectedReservationDTOs, result);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetAllReservationsByTravelRequestId_ResourceNotFoundException() throws ResourceNotFoundException {
        // Arrange
        int travelRequestId = 1;

        when(reservationsRepository.findAllByTravelRequestId(travelRequestId)).thenReturn(new ArrayList<>());

        // Act
        reservationsService.getAllReservationsByTravelRequestId(travelRequestId);

        // Exception expected: ResourceNotFoundException
    }

}
