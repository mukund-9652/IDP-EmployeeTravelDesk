//import static org.junit.Assert.assertEquals;
//
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import com.cognizant.employeetraveldesk.travelplanner.entity.Locations;
//import com.cognizant.employeetraveldesk.travelplanner.model.LocationsDTO;
//import com.cognizant.employeetraveldesk.travelplanner.repository.LocationsRepository;
//import com.cognizant.employeetraveldesk.travelplanner.service.LocationsService;
//import com.cognizant.employeetraveldesk.travelplanner.service.implementation.LocationsServiceImplementation;
//
//@RunWith(MockitoJUnitRunner.class)
//public class LocationsServiceTest {
//
//	@Mock
//	private LocationsRepository locationsRepository; // Assuming a LocationsRepository interface exists
//
//	@InjectMocks
//	private LocationsService locationsService = new LocationsServiceImplementation();
//
//	@Before
//	public void init() {
//		MockitoAnnotations.initMocks(this);
//	}
//
//	@Test
//	public void testReturnAllLocations() {
//		List<Locations> expectedLocations = new ArrayList<>();
//		// Add some sample locations to the expected list
//		LocationsDTO location1 = new LocationsDTO("Location 1");
//		LocationsDTO location2 = new LocationsDTO("Location 2");
////		expectedLocations.add(location1);
////		expectedLocations.add(location2);
//
//		// Configure the mock repository to return the expected locations
//		when(locationsRepository.findAll()).thenReturn(expectedLocations);
//
//		// Call the service method
//		List<LocationsDTO> actualLocations = locationsService.returnAllLocations();
//
//		// Verify the result
//		assertEquals(expectedLocations.size(), actualLocations.size());
//		assertEquals(expectedLocations.get(0), actualLocations.get(0));
//		assertEquals(expectedLocations.get(1), actualLocations.get(1));
//	}
//}
