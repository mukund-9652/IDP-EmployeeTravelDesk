package com.cognizant.employeetraveldesk.reimbursement.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

@Entity
@Table(name = "reimbursementrequests")
public class ReimbursementRequests {

	public ReimbursementRequests() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", length = 10)
	private int id;

	@NotNull(message = "Travel Request Id cannot be null")
	@Min(value = 1, message = "Travel Request Id must be at least 1")
	@Column(name = "travelrequestid", length = 10)
	private int travelRequestId;

	@NotNull(message = "Employee Id cannot be null")
	@Column(name = "requestraisedbyemployeeid")
	private int requestRaisedByEmployeeId;

	@NotNull
	@Column(name = "requestdate")
	private LocalDate requestDate;

	@ManyToOne
	@JoinColumn(name = "reimbursementtypeid")
	private ReimbursementTypes reimbursementTypes;

	@NotNull
	@Size(min = 5, message = "Invoice Number cannot be null")
	@Column(name = "invoiceno", length = 20)
	private String invoiceNo;

	@NotNull
	@PastOrPresent(message = "Invoice Date cannot be a future date")
	@Column(name = "invoicedate")
	private LocalDate invoiceDate;

	@NotNull(message = "Invoice Amount cannot be null")
	@Column(name = "invoiceamount")
	private int invoiceAmount;

	@NotNull(message = "Document URL cannot be null")
	@Column(name = "documenturl", length = 200)
	private String documentURL;

	@PastOrPresent(message = "Processed On Date cannot be a past date")
	@Column(nullable = true, name = "requestprocessedon")
	private LocalDate requestProcessedOn;

	@Column(nullable = true, name = "requestprocessedbyemployeeid")
	private Integer requestProcessedByEmployeeId;

	@NotNull(message = "Status cannot be null")
	@Column(name = "status", length = 10)
	private String status;

	@Column(name = "remarks", length = 100)
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

	@PrePersist
	public void prePersist() {
		requestDate = LocalDate.now();
	}

	public ReimbursementTypes getReimbursementTypes() {
		return reimbursementTypes;
	}

	public void setReimbursementTypes(ReimbursementTypes reimbursementTypes) {
		this.reimbursementTypes = reimbursementTypes;
	}

	public ReimbursementRequests(int id, @NotNull int travelRequestId, @NotNull int requestRaisedByEmployeeId,
			@NotNull LocalDate requestDate, ReimbursementTypes reimbursementTypes, @NotNull String invoiceNo,
			@NotNull @PastOrPresent LocalDate invoiceDate, @NotNull int invoiceAmount, @NotNull String documentURL,
			@FutureOrPresent LocalDate requestProcessedOn, Integer requestProcessedByEmployeeId, @NotNull String status,
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

}
