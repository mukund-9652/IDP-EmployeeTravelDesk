package com.cognizant.employeetraveldesk.reimbursement.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.cognizant.employeetraveldesk.reimbursement.entity.ReimbursementTypes;

public class ReimbursementRequestsDTO {

	public ReimbursementRequestsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReimbursementRequestsDTO(int id, int travelRequestId, int requestRaisedByEmployeeId, LocalDate requestDate,
			ReimbursementTypes reimbursementTypes, String invoiceNo, LocalDate invoiceDate, int invoiceAmount,
			String documentURL, LocalDate requestProcessedOn, Integer requestProcessedByEmployeeId, String status,
			String remarks) {
		super();
		this.id = id;
		this.travelRequestId = travelRequestId;
		this.requestRaisedByEmployeeId = requestRaisedByEmployeeId;
		this.requestDate = requestDate;
		this.reimbursementTypes = reimbursementTypes;
		this.invoiceNo = invoiceNo;
		this.invoiceDate = invoiceDate;
		this.invoiceAmount = invoiceAmount;
		this.documentURL = documentURL;
		this.requestProcessedOn = requestProcessedOn;
		this.requestProcessedByEmployeeId = requestProcessedByEmployeeId;
		this.status = status;
		this.remarks = remarks;
	}

	private int id;

	@Min(value = 1, message = "Travel Request Id must be at least 1")
	private int travelRequestId;

	@Min(value = 1, message = "Employee Id must be at least 1")
	@Column(name = "requestraisedbyemployeeid")
	private int requestRaisedByEmployeeId;

	private LocalDate requestDate;

	private ReimbursementTypes reimbursementTypes;

	@NotBlank(message = "Invoice Number cannot be null/empty")
	@Size(min = 5, message = "Invoice Number must have more than 5 symbols")
	private String invoiceNo;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent(message = "Invoice Date cannot be a future date or should not be null")
	private LocalDate invoiceDate;

	@Min(value = 10, message = "Invoice Amount must be at least Rs.10")
	private int invoiceAmount;

	@NotBlank(message = "Document URL Should not be null/empty")
	private String documentURL;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@FutureOrPresent(message = "Processed On Date cannot be a past date")
	private LocalDate requestProcessedOn;

	private Integer requestProcessedByEmployeeId;

	@NotBlank(message = "Status cannot be null/empty")
	@Pattern(regexp = "New|Rejected|Approved", message = "Invalid Status. Status should exactly be New | Approved | Rejected")
	private String status;

	private String remarks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTravelRequestId() {
		return travelRequestId;
	}

	public void setTravelRequestId(int travelRequestId) {
		this.travelRequestId = travelRequestId;
	}

	public int getRequestRaisedByEmployeeId() {
		return requestRaisedByEmployeeId;
	}

	public void setRequestRaisedByEmployeeId(int requestRaisedByEmployeeId) {
		this.requestRaisedByEmployeeId = requestRaisedByEmployeeId;
	}

	public LocalDate getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(LocalDate requestDate) {
		this.requestDate = requestDate;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public int getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(int invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public String getDocumentURL() {
		return documentURL;
	}

	public void setDocumentURL(String documentURL) {
		this.documentURL = documentURL;
	}

	public LocalDate getRequestProcessedOn() {
		return requestProcessedOn;
	}

	public void setRequestProcessedOn(LocalDate requestProcessedOn) {
		this.requestProcessedOn = requestProcessedOn;
	}

	public Integer getRequestProcessedByEmployeeId() {
		return requestProcessedByEmployeeId;
	}

	public void setRequestProcessedByEmployeeId(Integer requestProcessedByEmployeeId) {
		this.requestProcessedByEmployeeId = requestProcessedByEmployeeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public ReimbursementTypes getReimbursementTypes() {
		return reimbursementTypes;
	}

	public void setReimbursementTypes(ReimbursementTypes reimbursementTypes) {
		this.reimbursementTypes = reimbursementTypes;
	}

	@Override
	public String toString() {
		return "ReimbursementRequestsDTO [id=" + id + ", travelRequestId=" + travelRequestId
				+ ", requestRaisedByEmployeeId=" + requestRaisedByEmployeeId + ", requestDate=" + requestDate
				+ ", reimbursementTypes=" + reimbursementTypes + ", invoiceNo=" + invoiceNo + ", invoiceDate="
				+ invoiceDate + ", invoiceAmount=" + invoiceAmount + ", documentURL=" + documentURL
				+ ", requestProcessedOn=" + requestProcessedOn + ", requestProcessedByEmployeeId="
				+ requestProcessedByEmployeeId + ", status=" + status + ", remarks=" + remarks + "]";
	}

}
