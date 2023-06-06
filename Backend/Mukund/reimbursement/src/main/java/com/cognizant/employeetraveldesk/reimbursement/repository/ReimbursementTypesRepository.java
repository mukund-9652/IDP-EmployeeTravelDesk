package com.cognizant.employeetraveldesk.reimbursement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cognizant.employeetraveldesk.reimbursement.entity.ReimbursementTypes;

public interface ReimbursementTypesRepository extends JpaRepository<ReimbursementTypes, Integer> {
}
