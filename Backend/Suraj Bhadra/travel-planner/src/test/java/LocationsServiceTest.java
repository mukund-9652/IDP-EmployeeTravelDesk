//package com.cognizant.employeetraveldesk.travelplanner.service.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cognizant.employeetraveldesk.travelplanner.mapper.ModelMapper;
import com.cognizant.employeetraveldesk.travelplanner.model.LocationsDTO;
import com.cognizant.employeetraveldesk.travelplanner.repository.LocationsRepository;
import com.cognizant.employeetraveldesk.travelplanner.service.implementation.LocationsServiceImplementation;

public class LocationsServiceTest {

    @Mock
    private LocationsRepository locationsRepository;

    @InjectMocks
    private LocationsServiceImplementation locationsService;

    private ModelMapper modelMapper = new ModelMapper();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testReturnAllLocations() {
        // Mock data
        List<LocationsDTO> mockLocations = new ArrayList<>();
        LocationsDTO location1 = new LocationsDTO();
        location1.setId(1);
        location1.setName("Location 1");
        LocationsDTO location2 = new LocationsDTO();
        location2.setId(2);
        location2.setName("Location 2");
        mockLocations.add(location1);
        mockLocations.add(location2);

        // Mock repository method
        //when(locationsRepository.findAll()).thenReturn(modelMapper.convertDTOToEntity(mockLocations));

        // Perform the service method
        List<LocationsDTO> result = locationsService.returnAllLocations();

        // Verify the result
        assertEquals(2, result.size());
        assertEquals("Location 1", result.get(0).getName());
        assertEquals("Location 2", result.get(1).getName());
    }
}
