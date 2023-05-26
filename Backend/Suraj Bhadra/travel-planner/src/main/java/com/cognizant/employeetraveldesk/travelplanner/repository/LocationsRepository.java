package com.cognizant.employeetraveldesk.travelplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.employeetraveldesk.travelplanner.entity.Locations;

//creating a spring data jpa repository
public interface LocationsRepository extends JpaRepository<Locations, Integer> {

}
