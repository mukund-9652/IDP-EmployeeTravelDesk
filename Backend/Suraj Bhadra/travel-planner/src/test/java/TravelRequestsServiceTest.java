//import static org.mockito.Mockito.when;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.ArgumentMatchers.any;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.assertFalse;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import com.cognizant.employeetraveldesk.reservations.exception.DuplicateResourceException;
//import com.cognizant.employeetraveldesk.reservations.exception.InvalidResourceException;
//import com.cognizant.employeetraveldesk.reservations.exception.ResourceNotFoundException;
//import com.cognizant.employeetraveldesk.travelplanner.model.TravelRequestsDTO;
//import com.cognizant.employeetraveldesk.travelplanner.repository.TravelRequestsRepository;
//import com.cognizant.employeetraveldesk.travelplanner.service.TravelRequestsService;
//
//
//@RunWith(MockitoJUnitRunner.class)
//public class TravelRequestsServiceTest {
//
//	@Mock
//	private TravelRequestsRepository travelRequestsRepository; // Assuming a TravelRequestsRepository interface exists
//
//	@InjectMocks
//	private TravelRequestsService travelRequestsService = new TravelRequestsService() {
//		
//		@Override
//		public boolean updateTravelRequestsById(int trid, TravelRequestsDTO travelRequestsDTO)
//				throws ResourceNotFoundException, InvalidResourceException {
//			// TODO Auto-generated method stub
//			return false;
//		}
//		
//		@Override
//		public TravelRequestsDTO retrieveTravelRequestById(int trid) throws ResourceNotFoundException {
//			// TODO Auto-generated method stub
//			return null;
//		}
//		
//		@Override
//		public TravelRequestsDTO retrieveTravelRequestByHRid(int HRid) throws ResourceNotFoundException {
//			// TODO Auto-generated method stub
//			return null;
//		}
//		
//		@Override
//		public int createTravelRequest(TravelRequestsDTO travelRequestsDTO)
//				throws DuplicateResourceException, InvalidResourceException {
//			// TODO Auto-generated method stub
//			return 0;
//		}
//	};
//
//	@Before
//	public void init() {
//		MockitoAnnotations.initMocks(this);
//	}
//
//	@Test
//	public void testCreateTravelRequest() throws DuplicateResourceException, InvalidResourceException {
//		TravelRequestsDTO travelRequest = new TravelRequestsDTO();
//		travelRequest.setRequestId(123);
//		// Add any other required fields for the travel request
//
//		when(travelRequestsRepository.save(any(TravelRequestsDTO.class))).thenReturn(travelRequest);
//
//		int requestId = travelRequestsService.createTravelRequest(travelRequest);
//
//		assertNotNull(requestId);
//		assertEquals(123, requestId);
//	}
//
//	@Test(expected = DuplicateResourceException.class)
//	public void testCreateDuplicateTravelRequest() throws DuplicateResourceException, InvalidResourceException {
//		TravelRequestsDTO travelRequest = new TravelRequestsDTO();
//		// Set up the mock repository to throw DuplicateResourceException when saving a duplicate request
//		when(travelRequestsRepository.save(any(TravelRequestsDTO.class))).thenThrow(DuplicateResourceException.class);
//
//		travelRequestsService.createTravelRequest(travelRequest);
//	}
//
//	@Test
//	public void testRetrieveTravelRequestByHRid() throws ResourceNotFoundException {
//		TravelRequestsDTO expectedRequest = new TravelRequestsDTO();
//		expectedRequest.setRequestId(123);
//		// Set up the mock repository to return the expected request when searching by HR id
//		when(travelRequestsRepository.findById(anyInt())).thenReturn(expectedRequest);
//
//		TravelRequestsDTO actualRequest = travelRequestsService.retrieveTravelRequestByHRid(123);
//
//		assertEquals(expectedRequest.getRequestId(), actualRequest.getRequestId());
//	}
//
//	@Test(expected = ResourceNotFoundException.class)
//	public void testRetrieveNonExistingTravelRequestByHRid() throws ResourceNotFoundException {
//		// Set up the mock repository to return null when searching for a non-existing request
//		when(travelRequestsRepository.findById(anyInt())).thenReturn(null);
//
//		travelRequestsService.retrieveTravelRequestByHRid(123);
//	}
//
//	@Test
//	public void testRetrieveTravelRequestById() throws ResourceNotFoundException {
//		TravelRequestsDTO expectedRequest = new TravelRequestsDTO();
//		expectedRequest.setRequestId(456);
//		// Set up the mock repository to return the expected request when searching by request id
//		when(travelRequestsRepository.findById(anyInt())).thenReturn(expectedRequest);
//
//		TravelRequestsDTO actualRequest = travelRequestsService.retrieveTravelRequestById(456);
//
//		assertEquals(expectedRequest.getRequestId(), actualRequest.getRequestId());
//	}
//
//	@Test(expected = ResourceNotFoundException.class)
//	public void testRetrieveNonExistingTravelRequestById() throws ResourceNotFoundException {
//		// Set up the mock repository to return null when searching for a non-existing request
//		when(travelRequestsRepository.findById(anyInt())).thenReturn(null);
//
//		travelRequestsService.retrieveTravelRequestById(456);
//	}
//
//	@Test
//	public void testUpdateTravelRequestsById() throws ResourceNotFoundException, InvalidResourceException {
//		TravelRequestsDTO travelRequest = new TravelRequestsDTO();
//		travelRequest.setRequestId(789);
//		// Add any other required fields for the travel request update
//
//		when(travelRequestsRepository.existsById(anyInt())).thenReturn(true);
//		when(travelRequestsRepository.save(any(TravelRequestsDTO.class))).thenReturn(travelRequest);
//
//		boolean isUpdated = travelRequestsService.updateTravelRequestsById(789, travelRequest);
//
//		assertTrue(isUpdated);
//	}
//
//	@Test(expected = ResourceNotFoundException.class)
//	public void testUpdateNonExistingTravelRequestsById() throws ResourceNotFoundException, InvalidResourceException {
//		TravelRequestsDTO travelRequest = new TravelRequestsDTO();
//		travelRequest.setRequestId(789);
//
//		when(travelRequestsRepository.existsById(anyInt())).thenReturn(false);
//
//		travelRequestsService.updateTravelRequestsById(789, travelRequest);
//	}
//
//	@Test(expected = InvalidResourceException.class)
//	public void testUpdateTravelRequestsWithInvalidData() throws ResourceNotFoundException, InvalidResourceException {
//		TravelRequestsDTO travelRequest = new TravelRequestsDTO();
//		travelRequest.setRequestId(789);
//		// Set up the mock repository to throw InvalidResourceException when saving with invalid data
//		when(travelRequestsRepository.existsById(anyInt())).thenReturn(true);
//		when(travelRequestsRepository.save(any(TravelRequestsDTO.class))).thenThrow(InvalidResourceException.class);
//
//		travelRequestsService.updateTravelRequestsById(789, travelRequest);
//	}
//
//}
