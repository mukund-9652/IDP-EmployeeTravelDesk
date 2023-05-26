package com.cognizant.employeetraveldesk.reimbursement.service.mapper;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.employeetraveldesk.reimbursement.entity.ReimbursementRequests;
import com.cognizant.employeetraveldesk.reimbursement.model.ReimbursementRequestsDTO;

public class EntityDTOMapper {
	public ReimbursementRequests mapDTOToEntity(ReimbursementRequestsDTO requestsDTO) {
		ReimbursementRequests reimbursementRequests = new ReimbursementRequests(requestsDTO.getId(),
				requestsDTO.getTravelRequestId(), requestsDTO.getRequestRaisedByEmployeeId(),
				requestsDTO.getRequestDate(), requestsDTO.getReimbursementTypes(), requestsDTO.getInvoiceNo(),
				requestsDTO.getInvoiceDate(), requestsDTO.getInvoiceAmount(), requestsDTO.getDocumentURL(),
				requestsDTO.getRequestProcessedOn(), requestsDTO.getRequestProcessedByEmployeeId(),
				requestsDTO.getStatus(), requestsDTO.getRemarks());
		return reimbursementRequests;
	}

	public ReimbursementRequestsDTO mapEntityToDTO(ReimbursementRequests requests) {
		ReimbursementRequestsDTO reimbursementRequestsDTO = new ReimbursementRequestsDTO(requests.getId(),
				requests.getTravelRequestId(), requests.getRequestRaisedByEmployeeId(), requests.getRequestDate(),
				requests.getReimbursementTypes(), requests.getInvoiceNo(), requests.getInvoiceDate(),
				requests.getInvoiceAmount(), requests.getDocumentURL(), requests.getRequestProcessedOn(),
				requests.getRequestProcessedByEmployeeId(), requests.getStatus(), requests.getRemarks());
		return reimbursementRequestsDTO;
	}

	public List<ReimbursementRequests> mapDTOToEntity(List<ReimbursementRequestsDTO> requestsDTO) {
		List<ReimbursementRequests> result = new ArrayList<>();
		for (ReimbursementRequestsDTO request : requestsDTO) {
			result.add(this.mapDTOToEntity(request));
		}
		return result;
	}

	public List<ReimbursementRequestsDTO> mapEntityToDTO(List<ReimbursementRequests> requests) {
		List<ReimbursementRequestsDTO> result = new ArrayList<>();
		for (ReimbursementRequests requestDTO : requests) {
			result.add(this.mapEntityToDTO(requestDTO));
		}
		return result;
	}
}
