import { Component } from '@angular/core';

@Component({
  selector: 'app-upload-reservation',
  templateUrl: './reservation-upload.component.html',
  styleUrls: ['./reservation-upload.component.css']
})
export class UploadReservationComponent {
  reservationData: any = {
    employeeName: '',
    reservationDate: '',
    destination: '',
    reservationType: '',
  };    // Object to store reservation details

  isFormSubmitted: boolean = false;
  acknowledgmentMessage: string = '';

  constructor() { }

  uploadReservation() {
    if (this.validateForm()) {
      // Logic to upload reservation details to the server
      // You can implement an HTTP request or any other method here
      this.isFormSubmitted = true;
      this.acknowledgmentMessage = 'Reservation submitted successfully!';
    }
  }

  validateForm(): boolean {
    // Implement your form validation logic here
    // You can check if all required fields are filled, validate the format of input, etc.
    // Return true if the form is valid, otherwise return false
    return true; // Placeholder for demonstration, assuming the form is always valid
  }
}
