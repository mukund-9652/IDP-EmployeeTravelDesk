package com.cognizant.employeetraveldesk.travelplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.employeetraveldesk.travelplanner.entity.TravelRequests;

//creating a spring data jpa repository
public interface TravelRequestsRepository extends JpaRepository<TravelRequests, Integer> {
	TravelRequests findByToBeApprovedByHRId(int HRid);
}
