package com.cognizant.employeetraveldesk.humanresources.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.employeetraveldesk.humanresources.entity.GradesHistory;
import com.cognizant.employeetraveldesk.humanresources.entity.Users;

public interface GradesHistoryRepository extends JpaRepository<GradesHistory, Integer> {
	Optional<GradesHistory> findByEmployeeid(Users employeeId);
}
