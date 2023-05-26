package com.cognizant.employeetraveldesk.travelplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.employeetraveldesk.travelplanner.entity.TravelBudgetAllocations;

//creating a spring data jpa repository
public interface TravelBudgetAllocationsRepository extends JpaRepository<TravelBudgetAllocations, Integer> {

}
