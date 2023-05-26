package com.cognizant.employeetraveldesk.reimbursement.service.implementation;

import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.employeetraveldesk.reimbursement.entity.ReimbursementRequests;
import com.cognizant.employeetraveldesk.reimbursement.exception.DuplicateResourceException;
import com.cognizant.employeetraveldesk.reimbursement.exception.InvalidResourceException;
import com.cognizant.employeetraveldesk.reimbursement.exception.ResourceNotFoundException;
import com.cognizant.employeetraveldesk.reimbursement.model.ReimbursementRequestsDTO;
import com.cognizant.employeetraveldesk.reimbursement.repository.ReimbursementRequestsRepository;
import com.cognizant.employeetraveldesk.reimbursement.service.ReimbursementRequestsService;
import com.cognizant.employeetraveldesk.reimbursement.service.mapper.EntityDTOMapper;

@Service
public class ReimbursementRequestsServiceImpl implements ReimbursementRequestsService {

	@Autowired
	ReimbursementRequestsRepository reimbursementRequestsRepository;

	private EntityDTOMapper entityDTOMapper = new EntityDTOMapper();

	@Override
	public boolean createRequest(ReimbursementRequestsDTO requestDTO)
			throws DuplicateResourceException, InvalidResourceException {
		// TODO Auto-generated method stub

		Optional<ReimbursementRequests> result;
		ReimbursementRequests reimbursementRequests = entityDTOMapper.mapDTOToEntity(requestDTO);
		result = reimbursementRequestsRepository.findById(reimbursementRequests.getId());

		if (result.isPresent()) {
			throw new DuplicateResourceException(
					"Resource is already available for Id : " + reimbursementRequests.getId());
		}
		
		String fileUrl=reimbursementRequests.getDocumentURL();
		if (!fileUrl.contains(".pdf")) {
			throw new InvalidResourceException("Need to pass a PDF File");
		}
		
		if (!this.isFileSizeLessThan256KB(fileUrl)) {
			throw new InvalidResourceException("Invalid Document Size! It must be less than 256 kb");
		}

		if (!this.checkTravelPlannerDate(reimbursementRequests.getInvoiceDate())) {
			throw new InvalidResourceException("Invalid Invoice Date: " + reimbursementRequests.getInvoiceDate());
		}

		if (this.checkInvoiceAmount(reimbursementRequests)) {
			reimbursementRequestsRepository.save(reimbursementRequests);
			return true;
		}

		return false;
	}

	@Override
	public List<ReimbursementRequestsDTO> readAllRequestsForTravelRequestId(Integer travelRequestId)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		List<ReimbursementRequests> reimbursementRequestsEntity;
		List<ReimbursementRequestsDTO> reimbursementRequestsDTO = new ArrayList<ReimbursementRequestsDTO>();
		reimbursementRequestsEntity = reimbursementRequestsRepository.findByTravelRequestId(travelRequestId);

		if (reimbursementRequestsEntity.isEmpty()) {
			throw new ResourceNotFoundException("Travel Requests for the given id " + travelRequestId + " Not Found");
		}

		for (ReimbursementRequests requests : reimbursementRequestsEntity) {
			ReimbursementRequestsDTO requestDTO = entityDTOMapper.mapEntityToDTO(requests);
			reimbursementRequestsDTO.add(requestDTO);
		}

		return reimbursementRequestsDTO;
	}

	@Override
	public ReimbursementRequestsDTO readRequestByReimbursementId(int id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		ReimbursementRequests resultEntity;
		ReimbursementRequestsDTO resultDTO;

		Optional<ReimbursementRequests> result;
		result = reimbursementRequestsRepository.findById(id);

		if (result.isPresent()) {
			resultEntity = result.get();
			resultDTO = entityDTOMapper.mapEntityToDTO(resultEntity);
			return resultDTO;
		} else {
			throw new ResourceNotFoundException("Request for Id " + id + " was not found");
		}
	}

	@Override
	public boolean updateRequest(ReimbursementRequestsDTO requestDTO)
			throws ResourceNotFoundException, InvalidResourceException {
		// TODO Auto-generated method stub

		ReimbursementRequests request = entityDTOMapper.mapDTOToEntity(requestDTO);

		Optional<ReimbursementRequests> result = reimbursementRequestsRepository.findById(request.getId());
		if (result.isPresent()) {
			String updatedStatus = request.getStatus(), currentStatus = result.get().getStatus();
			if (currentStatus.equalsIgnoreCase(updatedStatus)) {
				throw new InvalidResourceException("You should only update the status and not any other values.");
			}

			if (request.getStatus().equalsIgnoreCase("Rejected") && request.getRemarks().isEmpty()) {
				throw new InvalidResourceException("Remaks cannot be Empty when the request is rejected.");
			}
			LocalDate updatedDate = LocalDate.now();
			request.setRequestProcessedOn(updatedDate);
			reimbursementRequestsRepository.save(request);
			return true;
		} else {
			throw new ResourceNotFoundException("Request for Id " + requestDTO.getId() + " was not found");
		}
	}

	/*
	 * This function is to check invoice date is with in the from and to date of the
	 * travel
	 */

	public boolean checkTravelPlannerDate(LocalDate inputDate) {
		LocalDate startDate = LocalDate.of(2023, 01, 01);
		LocalDate endDate = LocalDate.of(2024, 01, 01);

		if (inputDate.isBefore(startDate) || inputDate.isAfter(endDate)) {
			return false;
		}
		return true;
	}

	/*
	 * This function is to check and allow expense per day for food, laundry and
	 * local travel is as follows Food and water – upto 1500 per day Laundry – upto
	 * 500 per day Local travel – upto 1000 per day
	 */

	public boolean checkInvoiceAmount(ReimbursementRequests request) throws InvalidResourceException {

		try {
			List<Object[]> invoicePerDayDetails = reimbursementRequestsRepository
					.getReimbursementRequestsByEmployeeIdAndType(request.getRequestRaisedByEmployeeId(),
							request.getReimbursementTypes().getType());

			for (Object[] result : invoicePerDayDetails) {
				java.sql.Date sqlDate = (Date) result[1];
				LocalDate invoiceDate = sqlDate.toLocalDate();
				BigDecimal value = new BigDecimal(result[2].toString());
				Double invoiceAmount = value.doubleValue();
				String type = (String) result[3];

				if ((type.equalsIgnoreCase("Food") || type.equalsIgnoreCase("Water"))
						&& invoiceAmount + request.getInvoiceAmount() > 1500
						&& invoiceDate.isEqual(request.getInvoiceDate())) {
					throw new InvalidResourceException(
							"Invalid amount for Food/Water. Your food limit per day is 1500. Your current invoice amount for food/water is Rs."
									+ invoiceAmount + " for the date " + invoiceDate);
				} else if (type.equalsIgnoreCase("Laundry") && invoiceAmount + request.getInvoiceAmount() > 500
						&& invoiceDate.isEqual(request.getInvoiceDate())) {
					throw new InvalidResourceException(
							"Invalid amount for Laundry. Your food limit per day is 500. Your current invoice amount for Laundry is Rs."
									+ invoiceAmount + " for the date " + invoiceDate);
				} else if (type.equalsIgnoreCase("Local Travel") && invoiceAmount + request.getInvoiceAmount() > 1000
						&& invoiceDate.isEqual(request.getInvoiceDate())) {
					throw new InvalidResourceException(
							"Invalid amount for Local Travel. Your Local Travel limit per day is 1000. Your current invoice amount for Local Travel is Rs."
									+ invoiceAmount + " for the date " + invoiceDate);
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * This function is to check and allow documents for uploading is pdf with the
	 * size of 256kb
	 */

	public boolean isFileSizeLessThan256KB(String fileUrl) throws InvalidResourceException {
		try {
			
			URL url = new URL(fileUrl);
			URLConnection conn = url.openConnection();
			conn.connect();
			long fileSizeInBytes = conn.getContentLength();
			long fileSizeInKB = fileSizeInBytes / 1024;
			return fileSizeInKB <= 256;
		} catch (Exception e) {
			return false;
		}
	}

}
