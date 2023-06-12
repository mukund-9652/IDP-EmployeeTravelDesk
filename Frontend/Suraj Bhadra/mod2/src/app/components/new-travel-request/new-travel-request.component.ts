import { Component } from '@angular/core';

@Component({
  selector: 'app-new-travel-request',
  templateUrl: './new-travel-request.component.html',
  styleUrls: ['./new-travel-request.component.css']
})
export class NewTravelRequestComponent {
  travelRequest: any = {
    fromDate: '',
    toDate: '',
    location: '',
    purpose: '',
    priority: '',
    hrId: '555442' // Replace 'HR123' with your logic to auto-populate HR ID
  };

  submitted: boolean = false;
  generatedRequestId: string | null = null;

  submitForm() {
    if (!this.travelRequest.fromDate || !this.travelRequest.toDate || !this.travelRequest.location ||
        !this.travelRequest.purpose || !this.travelRequest.priority) {
      return; // Form validation failed
    }

    // Assuming you have some logic to generate the travel request ID
    //this.generatedRequestId = ''; 

    this.submitted = true;
  }
}
