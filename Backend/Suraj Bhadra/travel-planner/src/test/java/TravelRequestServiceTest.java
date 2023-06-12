//package com.cognizant.employeetraveldesk.travelplanner.service.implementation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cognizant.employeetraveldesk.reservations.exception.DuplicateResourceException;
import com.cognizant.employeetraveldesk.reservations.exception.InvalidResourceException;
import com.cognizant.employeetraveldesk.reservations.exception.ResourceNotFoundException;
import com.cognizant.employeetraveldesk.travelplanner.entity.TravelRequests;
import com.cognizant.employeetraveldesk.travelplanner.mapper.ModelMapper;
import com.cognizant.employeetraveldesk.travelplanner.model.TravelRequestsDTO;
import com.cognizant.employeetraveldesk.travelplanner.repository.TravelRequestsRepository;
import com.cognizant.employeetraveldesk.travelplanner.service.TravelRequestsService;
import com.cognizant.employeetraveldesk.travelplanner.service.implementation.TravelRequestServiceImplementation;

public class TravelRequestServiceTest {

    @Mock
    private TravelRequestsRepository travelRequestsRepository;

    @InjectMocks
    private TravelRequestServiceImplementation travelRequestService;

    private ModelMapper modelMapper = new ModelMapper();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateTravelRequest() throws DuplicateResourceException, InvalidResourceException {
        // Mock data
        TravelRequestsDTO travelRequestsDTO = new TravelRequestsDTO();
        travelRequestsDTO.setRequestId(1);
        travelRequestsDTO.setRaisedByEmployeeId(123);
        travelRequestsDTO.setPriority("priority-1");

        // Mock repository method
        when(travelRequestsRepository.findById(1)).thenReturn(Optional.empty());
        when(travelRequestsRepository.save(any(TravelRequests.class))).thenReturn(new TravelRequests());

        // Perform the service method
        int result = travelRequestService.createTravelRequest(travelRequestsDTO);

        // Verify the result
        assertEquals(1, result);
    }

    @Test
    public void testRetrieveTravelRequestByHRid() throws ResourceNotFoundException {
        // Mock data
        int hrId = 123;
        TravelRequests travelRequest = new TravelRequests();
        travelRequest.setRaisedByEmployeeId(123);
        travelRequest.setToBeApprovedByHRId(hrId);

        // Mock repository method
        when(travelRequestsRepository.findByToBeApprovedByHRId(hrId)).thenReturn(travelRequest);

        // Perform the service method
        TravelRequestsDTO result = travelRequestService.retrieveTravelRequestByHRid(hrId);

        // Verify the result
        assertEquals(hrId, result.getToBeApprovedByHRId());
        assertEquals(123, result.getRaisedByEmployeeId());
    }

    @Test
    public void testRetrieveTravelRequestById() throws ResourceNotFoundException {
        // Mock data
        int requestId = 1;
        TravelRequests travelRequest = new TravelRequests();
        travelRequest.setRequestId(requestId);

        // Mock repository method
        when(travelRequestsRepository.findById(requestId)).thenReturn(Optional.of(travelRequest));

        // Perform the service method
        TravelRequestsDTO result = travelRequestService.retrieveTravelRequestById(requestId);

        // Verify the result
        assertEquals(requestId, result.getRequestId());
    }

    @Test
    public void testUpdateTravelRequestsById() throws ResourceNotFoundException {
        // Mock data
        int requestId = 1;
        TravelRequestsDTO travelRequestsDTO = new TravelRequestsDTO();
        travelRequestsDTO.setRequestId(requestId);

        // Mock repository method
        when(travelRequestsRepository.findById(requestId)).thenReturn(Optional.of(new TravelRequests()));
        when(travelRequestsRepository.save(any(TravelRequests.class))).thenReturn(new TravelRequests());

        // Perform the service method
        boolean result = travelRequestService.updateTravelRequestsById(requestId, travelRequestsDTO);

        // Verify the result
        assertTrue(result);
    }
}
