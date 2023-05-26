package com.cognizant.employeetraveldesk.reimbursement.service.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.employeetraveldesk.reimbursement.entity.ReimbursementRequests;
import com.cognizant.employeetraveldesk.reimbursement.entity.ReimbursementTypes;
import com.cognizant.employeetraveldesk.reimbursement.exception.DuplicateResourceException;
import com.cognizant.employeetraveldesk.reimbursement.exception.InvalidResourceException;
import com.cognizant.employeetraveldesk.reimbursement.exception.ResourceNotFoundException;
import com.cognizant.employeetraveldesk.reimbursement.model.ReimbursementRequestsDTO;
import com.cognizant.employeetraveldesk.reimbursement.repository.ReimbursementRequestsRepository;
import com.cognizant.employeetraveldesk.reimbursement.service.mapper.EntityDTOMapper;

/**
 * @author HP
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ReimbursementRequestsServiceImplTest {

	@InjectMocks
	private ReimbursementRequestsServiceImpl reimbursementRequestsServiceImpl;

	@Mock
	private ReimbursementRequestsRepository reimbursementRequestsRepository;

	private EntityDTOMapper entityDTOMapper = new EntityDTOMapper();

	private LocalDate currentDate = LocalDate.now();

	@BeforeClass
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	/*
	 * Testing Methods for Success Outputs
	 */

	/*
	 * TEST - 1 : Testing the createRequest method for ReimbursementRequestService -
	 * SUCCESS
	 */

	@Test
	public void creatingRequestsSuccessTest() throws DuplicateResourceException, InvalidResourceException {
		ReimbursementRequestsDTO reimbursementRequestDTO = new ReimbursementRequestsDTO(100, 1234567, 9876543,
				currentDate, new ReimbursementTypes(1, "Food"), "1928374", LocalDate.of(2023, 1, 21), 1500,
				"https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf", null, null, "New", "");

		ReimbursementRequests reimbursementRequest = entityDTOMapper.mapDTOToEntity(reimbursementRequestDTO);
		when(reimbursementRequestsRepository.save(any(ReimbursementRequests.class))).thenReturn(reimbursementRequest);

		boolean createRequest = reimbursementRequestsServiceImpl.createRequest(reimbursementRequestDTO);

		verify(reimbursementRequestsRepository).save(any(ReimbursementRequests.class));

		assertTrue(createRequest);
	}

	/*
	 * TEST - 2 : Testing the readAllRequestsForTravelRequestId method for
	 * ReimbursementRequestService - SUCCESS
	 */

	@Test
	public void readAllRequestsForTravelRequestIdTest() {
		List<ReimbursementRequestsDTO> requestListTestDTO = new ArrayList<>(Arrays.asList(
				(new ReimbursementRequestsDTO(100, 1234567, 9876543, currentDate, new ReimbursementTypes(1, "Food"),
						"1928374", LocalDate.of(2023, 1, 21), 1500,
						"https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf", null, null, "New",
						"")),
				new ReimbursementRequestsDTO(101, 1234567, 9876543, currentDate, new ReimbursementTypes(2, "Water"),
						"1928398", LocalDate.of(2023, 1, 22), 1650,
						"https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf", null, null, "New",
						""),
				new ReimbursementRequestsDTO(102, 1234567, 9876543, currentDate, new ReimbursementTypes(3, "Laundry"),
						"1925678", LocalDate.of(2023, 1, 22), 1050,
						"https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf", null, null, "New",
						"")));

		when(reimbursementRequestsRepository.findByTravelRequestId(1234567))
				.thenReturn(entityDTOMapper.mapDTOToEntity(requestListTestDTO));

		List<ReimbursementRequestsDTO> actualListDTO = reimbursementRequestsServiceImpl
				.readAllRequestsForTravelRequestId(1234567);

		assertEquals(requestListTestDTO.get(0).toString(), actualListDTO.get(0).toString());

		assertEquals(requestListTestDTO.get(1).toString(), actualListDTO.get(1).toString());

		assertEquals(requestListTestDTO.get(2).toString(), actualListDTO.get(2).toString());
	}

	/*
	 * TEST - 3 : Testing the readRequestByEmployeeId method for
	 * ReimbursementRequestService - SUCCESS
	 */

	@Test
	public void readRequestByEmployeeIdTestSuccess() {
		ReimbursementRequestsDTO reimbursementRequestDTO = new ReimbursementRequestsDTO(100, 1234567, 9876543,
				currentDate, new ReimbursementTypes(1, "Food"), "1928374", LocalDate.of(2023, 1, 21), 1500,
				"https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf", null, null, "New", "");

		Optional<ReimbursementRequestsDTO> reimbursementRequest = Optional.of(reimbursementRequestDTO);

		when(reimbursementRequestsRepository.findById(100))
				.thenReturn(Optional.of(entityDTOMapper.mapDTOToEntity(reimbursementRequest.get())));

		ReimbursementRequestsDTO findRequest = reimbursementRequestsServiceImpl.readRequestByReimbursementId(100);

		verify(reimbursementRequestsRepository).findById(100);

		assertEquals(reimbursementRequest.get().toString(), findRequest.toString());
	}

	/*
	 * TEST - 4 : Testing the updateRequest method for ReimbursementRequestService -
	 * SUCCESS
	 */

	@Test
	public void updateRequestTestSuccess()
			throws DuplicateResourceException, ResourceNotFoundException, InvalidResourceException {
		ReimbursementRequestsDTO reimbursementRequestDTO = new ReimbursementRequestsDTO(100, 1234567, 9876543,
				currentDate, new ReimbursementTypes(1, "Food"), "1928374", LocalDate.of(2023, 1, 21), 1500,
				"https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf", null, null, "New", "");

		ReimbursementRequests reimbursementRequest = entityDTOMapper.mapDTOToEntity(reimbursementRequestDTO);
		when(reimbursementRequestsRepository.save(any(ReimbursementRequests.class))).thenReturn(reimbursementRequest);

		boolean createRequest = reimbursementRequestsServiceImpl.createRequest(reimbursementRequestDTO);

		verify(reimbursementRequestsRepository).save(any(ReimbursementRequests.class));

		assertTrue(createRequest);

		reimbursementRequest.setStatus("Approved");

		when(reimbursementRequestsRepository.findById(100)).thenReturn(Optional.of(reimbursementRequest));

		when(reimbursementRequestsRepository.save(any(ReimbursementRequests.class))).thenReturn(reimbursementRequest);

		boolean updatedRequest = reimbursementRequestsServiceImpl.updateRequest(reimbursementRequestDTO);

		assertTrue(updatedRequest);
	}

	/*
	 * Testing for Negative Cases that throws exceptions
	 */

	/*
	 * TEST - 1 : Testing the createRequest method for ReimbursementRequestService -
	 * Fail due to Duplicate entry
	 */

	@Test
	public void createRequestTestFail_DuplicateResourceExceptionThrown() throws DuplicateResourceException {
		ReimbursementRequestsDTO reimbursementRequestDTO = new ReimbursementRequestsDTO(100, 1234567, 9876543,
				currentDate, new ReimbursementTypes(1, "Food"), "1928374", LocalDate.of(2023, 1, 21), 1500,
				"https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf", null, null, "New", "");

		when(reimbursementRequestsRepository.save(any(ReimbursementRequests.class)))
				.thenThrow(DuplicateResourceException.class);

		assertThrows(DuplicateResourceException.class, () -> {
			reimbursementRequestsServiceImpl.createRequest(reimbursementRequestDTO);
		});

	}

	/*
	 * TEST - 2 : Testing the createRequest method for ReimbursementRequestService -
	 * Fail due to Invalid Resource : Invalid Invoice Date
	 */

	@Test
	public void createRequestTestFail_InvalidResourceException_InvalidInvoiceDate() throws InvalidResourceException {
		ReimbursementRequestsDTO reimbursementRequestDTO = new ReimbursementRequestsDTO(100, 1234567, 9876543,
				currentDate, new ReimbursementTypes(1, "Food"), "1928374", LocalDate.of(2022, 1, 21), 1500,
				"https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf", null, null, "New", "");

		when(reimbursementRequestsRepository.save(any())).thenThrow(InvalidResourceException.class);

		assertThrows(InvalidResourceException.class,
				() -> reimbursementRequestsServiceImpl.createRequest(reimbursementRequestDTO));
	}

	/*
	 * TEST - 3 : Testing the createRequest method for ReimbursementRequestService -
	 * Fail due to Invalid Resource : Invalid Invoice Amount
	 */

	@Test
	public void createRequestTestFail_InvalidResourceException_InvalidInvoiceAmount() throws InvalidResourceException {
		ReimbursementRequestsDTO reimbursementRequestDTO = new ReimbursementRequestsDTO(100, 1234567, 9876543,
				currentDate, new ReimbursementTypes(1, "Food"), "1928374", LocalDate.of(2023, 1, 21), 11500,
				"https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf", null, null, "New", "");

		when(reimbursementRequestsRepository.save(any())).thenThrow(InvalidResourceException.class);
		assertThrows(InvalidResourceException.class,
				() -> reimbursementRequestsServiceImpl.createRequest(reimbursementRequestDTO));
	}

	/*
	 * TEST - 4 : Testing the createRequest method for ReimbursementRequestService -
	 * Fail due to Invalid Resource : Invalid Invoice Amount
	 */

	@Test
	public void createRequestTestFail_InvalidResourceException_InvalidDocumentSize() throws InvalidResourceException {
		ReimbursementRequestsDTO reimbursementRequestDTO = new ReimbursementRequestsDTO(100, 1234567, 9876543,
				currentDate, new ReimbursementTypes(1, "Food"), "1928374", LocalDate.of(2023, 1, 21), 11500,
				"https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf", null, null, "New", "");

		when(reimbursementRequestsRepository.save(any())).thenThrow(InvalidResourceException.class);
		assertThrows(InvalidResourceException.class,
				() -> reimbursementRequestsServiceImpl.createRequest(reimbursementRequestDTO));
	}

	/*
	 * TEST - 5 : Testing the readRequest method for ReimbursementRequestService -
	 * Fail due to Resource Not Found
	 */

	@Test
	public void readRequestTestFail_ResourceNotFoundException() throws ResourceNotFoundException {

		when(reimbursementRequestsRepository.findById(100)).thenThrow(ResourceNotFoundException.class);
		
		assertThrows(ResourceNotFoundException.class,() -> reimbursementRequestsServiceImpl.readRequestByReimbursementId(100));
	}

	/*
	 * TEST - 6 : Testing the readAllRequestsForTravelRequestId method for
	 * ReimbursementRequestService - Fail due to Resource Not Found
	 */

	@Test
	public void readAllRequestsForTravelRequestIdTestFail_ResourceNotFoundException() throws ResourceNotFoundException {

		when(reimbursementRequestsRepository.findByTravelRequestId(1234567)).thenThrow(ResourceNotFoundException.class);
		
		assertThrows(ResourceNotFoundException.class,() -> reimbursementRequestsServiceImpl.readAllRequestsForTravelRequestId(100));
	}
	
	/*
	 * TEST - 4 : Testing the createRequest method for ReimbursementRequestService -
	 * Fail due to Invalid Resource : Invalid Invoice Amount
	 */

	@Test
	public void createRequestTestFail_ValidationException_StatusType() throws InvalidResourceException {
		ReimbursementRequestsDTO reimbursementRequestDTO = new ReimbursementRequestsDTO(100, 1234567, 9876543,
				currentDate, new ReimbursementTypes(1, "Food"), "1928374", LocalDate.of(2023, 1, 21), 1200,
				"https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf", null, null, "Reject", "");

		when(reimbursementRequestsRepository.save(any())).thenThrow(InvalidResourceException.class);
		assertThrows(InvalidResourceException.class,
				() -> reimbursementRequestsServiceImpl.createRequest(reimbursementRequestDTO));
	}
	
	/*
	 * TEST - 5 : Testing the createRequest method for ReimbursementRequestService -
	 * Fail due to Invalid Resource : Invalid Document URL
	 */

	@Test
	public void createRequestTestFail_ValidationException_URL() throws InvalidResourceException {
		ReimbursementRequestsDTO reimbursementRequestDTO = new ReimbursementRequestsDTO(100, 1234567, 9876543,
				currentDate, new ReimbursementTypes(1, "Food"), "1928374", LocalDate.of(2023, 1, 21), 1200,
				"www.google.com", null, null, "Reject", "");

		when(reimbursementRequestsRepository.save(any())).thenThrow(InvalidResourceException.class);
		assertThrows(InvalidResourceException.class,
				() -> reimbursementRequestsServiceImpl.createRequest(reimbursementRequestDTO));
	}


}
