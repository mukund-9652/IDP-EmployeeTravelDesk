package com.cognizant.employeetraveldesk.reimbursement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.employeetraveldesk.reimbursement.entity.ReimbursementRequests;

public interface ReimbursementRequestsRepository extends JpaRepository<ReimbursementRequests, Integer> {

	List<ReimbursementRequests> findByTravelRequestId(int id);
	
	@Query(value = "SELECT R.REQUESTRAISEDBYEMPLOYEEID, R.INVOICEDATE, SUM(R.INVOICEAMOUNT), T.TYPE FROM REIMBURSEMENTREQUESTS R, REIMBURSEMENTTYPES T WHERE R.REIMBURSEMENTTYPEID = T.ID AND REQUESTRAISEDBYEMPLOYEEID = :employeeId AND T.TYPE = :type GROUP BY R.REQUESTRAISEDBYEMPLOYEEID, R.INVOICEDATE,T.TYPE", nativeQuery = true)
    List<Object[]> getReimbursementRequestsByEmployeeIdAndType(int employeeId,String type);
}
