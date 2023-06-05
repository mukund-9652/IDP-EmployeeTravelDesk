import { Component } from '@angular/core';

@Component({
  selector: 'app-travel-request-details',
  templateUrl: './travel-request-details.component.html',
  styleUrls: ['./travel-request-details.component.css']
})
export class TravelRequestDetailsComponent {
  isHRView: boolean = false;
  travelRequestId: string = '';
  travelRequest: any;

  searchRequest() {
    // Perform the logic to fetch travel request details based on travelRequestId
    // Replace this with your own logic or API call
    this.travelRequest = {
      id: this.travelRequestId,
      fromDate: '2023-06-10',
      toDate: '2023-06-15',
      location: 'Kolkata',
      purpose: 'Business Trip',
      priority: 'High',
      approved: true,
      budget: 1500,
      modeOfTravel: 'Flight',
      hotelStarRating: '4'
    };
  }

  submitApproval() {
    // Perform the logic to submit the approval
    // Replace this with your own logic or API call

    // Display an acknowledgement to the HR
    alert('Approval submitted successfully!');
  }
}

