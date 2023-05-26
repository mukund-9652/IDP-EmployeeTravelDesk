package com.cognizant.employeetraveldesk.travelplanner.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.employeetraveldesk.travelplanner.entity.Locations;
import com.cognizant.employeetraveldesk.travelplanner.entity.TravelRequests;
import com.cognizant.employeetraveldesk.travelplanner.model.LocationsDTO;
import com.cognizant.employeetraveldesk.travelplanner.model.TravelRequestsDTO;

@Component
public class ModelMapper {
	public LocationsDTO convertEntityToDTO(Locations location) {
		LocationsDTO result=new LocationsDTO(
				location.getId(),
				location.getName()
				);
		
		return result;
	}
	public TravelRequestsDTO convertEntityToDTO(TravelRequests travelRequests) {
		TravelRequestsDTO result=new TravelRequestsDTO(
				travelRequests.getRequestId(),
				travelRequests.getRaisedByEmployeeId(),
				travelRequests.getToBeApprovedByHRId(),
				travelRequests.getRequestRaisedOn(),
				travelRequests.getFromDate(),
				travelRequests.getToDate(),
				travelRequests.getPurposeOfTravel(),
				travelRequests.getLocations(),
				travelRequests.getRequestStatus(),
				travelRequests.getRequestApprovedOn(),
				travelRequests.getPriority(),
				travelRequests.getTravelBudgetAllocations()
				);
		
		return result;
	}
	public TravelRequests convertDTOToEntity(TravelRequestsDTO travelRequestsDTO) {
		TravelRequests result=new TravelRequests(
				travelRequestsDTO.getRequestId(),
				travelRequestsDTO.getRaisedByEmployeeId(),
				travelRequestsDTO.getToBeApprovedByHRId(),
				travelRequestsDTO.getRequestRaisedOn(),
				travelRequestsDTO.getFromDate(),
				travelRequestsDTO.getToDate(),
				travelRequestsDTO.getPurposeOfTravel(),
				travelRequestsDTO.getLocations(),
				travelRequestsDTO.getRequestStatus(),
				travelRequestsDTO.getRequestApprovedOn(),
				travelRequestsDTO.getPriority(),
				travelRequestsDTO.getTravelBudgetAllocations()
				);
		
		return result;
	}
	public List<LocationsDTO> convertEntityToDTO(List<Locations> location) {
		List<LocationsDTO> result=new ArrayList<>();
		for(Locations entry:location) {
			result.add(convertEntityToDTO(entry));
		}
		return result;
	}
	public Locations convertDTOToEntity(LocationsDTO locationDTO) {
		Locations result=new Locations(
				locationDTO.getId(),
				locationDTO.getName()
				);
		
		return result;
	}
}
