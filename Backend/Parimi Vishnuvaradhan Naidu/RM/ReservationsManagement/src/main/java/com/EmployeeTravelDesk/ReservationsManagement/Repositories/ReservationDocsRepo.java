package com.EmployeeTravelDesk.ReservationsManagement.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeTravelDesk.ReservationsManagement.Entities.ReservationDocs;

public interface ReservationDocsRepo extends  JpaRepository<ReservationDocs,Integer> {

}
