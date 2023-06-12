
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ReservationService } from '../reservation.service';

interface ReservationDetails {
  id: number;
  reservationDoneByEmployeeId: number;
  travelRequestId: number;
  reservationTypes: {
    typeId: number,
    typeName: string
  };
  createdOn: Date;
  reservationDoneWithEntity: string;
  reservationDate: Date;
  amount: number;
  confirmationId: string;
  remarks: string;
}

@Component({
  selector: 'app-upload-reservation',
  templateUrl: './reservation-upload.component.html',
  styleUrls: ['./reservation-upload.component.css']
})
export class UploadReservationComponent implements OnInit {
  reservationData!:FormGroup;

  isFormSubmitted: boolean = false;
  acknowledgmentMessage: string = '';

  constructor(    private fb: FormBuilder,private reservationService: ReservationService
    ) { }

  ngOnInit(): void {
    this.reservationData = this.fb.group({
      id:"",
      reservationDoneByEmployeeId: "",
      travelRequestId: "",
      createdOn: "",
      reservationDoneWithEntity: "",
      reservationDate:"",
      amount: "",
      confirmationId: "",
      reservationTypes: {
        typeId: 0,
        typeName: ''
      }
    });
  }

  submitted: boolean = false;

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

  submit(value:any) {
    this.reservationService.addReservation(value).subscribe({
      error: (err) => {
        console.log(this.reservationData.value)
        console.log(err);
      }
    });
  }
  onSelectOption(event: any) {
    const reservationTypesValue = this.reservationData.get('reservationTypes')?.value;
    console.log('reservationTypesValue:', reservationTypesValue);
    
    if (reservationTypesValue) {
      try {
        const trimmedValue = reservationTypesValue.trim();
        const jsonObject = JSON.parse(trimmedValue);
        
        this.reservationData.get('reservationTypes')?.setValue(jsonObject);
        console.log(this.reservationData.value);
      } catch (error) {
        console.error('Error parsing JSON:', error);
      }
    }
  }
  
  
}
