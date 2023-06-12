package com.cognizant.employeetraveldesk.reservations.controller;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.employeetraveldesk.reservations.model.ReservationDocsDTO;
import com.cognizant.employeetraveldesk.reservations.service.implementation.ReservationDocsServiceImpl;

@Validated
@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/api/reservations")
public class ReservationDocsController {
	@Autowired
	ReservationDocsServiceImpl reservationDocsServiceImpl;
	
	@CrossOrigin(origins ="http://localhost:4200")
	@GetMapping("/{reservationid}/download")
	public ResponseEntity<Resource> getDocumentUrlById(@PathVariable int reservationid) {
		ReservationDocsDTO reservationDocsDTO = reservationDocsServiceImpl.getReservationDocsById(reservationid);

		if (reservationDocsDTO != null) {
			System.out.println(reservationDocsDTO.getDocumentURL().toString());
			// Access the URL from the entity
			String documentURL = reservationDocsDTO.getDocumentURL();

			try {
				// Create a UrlResource from the document URL
				Resource fileResource = new UrlResource(documentURL);

				// Extract the file name from the URL
				String fileName = documentURL.substring(documentURL.lastIndexOf("/") + 1);

				// Set the content disposition header for the downloadable file
				HttpHeaders headers = new HttpHeaders();
				headers.setContentDispositionFormData("attachment", fileName);

				// Set the content type based on the file extension
				MediaType mediaType = MediaType.parseMediaType("application/pdf"); // Assuming it's a PDF file
				headers.setContentType(mediaType);

				return ResponseEntity.ok().headers(headers).body(fileResource);
			} catch (MalformedURLException e) {
				// Handle the exception appropriately
				e.printStackTrace();
			}
		}

		return ResponseEntity.notFound().build();

	}

}
