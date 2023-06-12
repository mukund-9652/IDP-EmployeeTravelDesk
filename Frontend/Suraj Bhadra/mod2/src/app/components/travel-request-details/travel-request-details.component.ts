import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-travel-request-details',
  templateUrl: './travel-request-details.component.html',
  styleUrls: ['./travel-request-details.component.css']
})
export class TravelRequestDetailsComponent implements OnInit {
  isHRView: boolean = false;
  travelRequestId: string = '';
  travelRequest:any= null;

  constructor(private http:HttpClient){}

  request:any=null;

  ngOnInit(): void {
    
  }

  searchRequest(){
    // this.http.get(`localhost:8082/api/travelrequests/${this.travelRequestId}`).subscribe(
      this.http.get("localhost:8082/api/travelrequests/"+this.travelRequestId).subscribe(
      (data)=>{
        this.travelRequest=data;
      }
    )
  }
 
  // searchRequest() {
  //   // Perform the logic to fetch travel request details based on travelRequestId
  //   // Replace this with your own logic or API call
  //   this.travelRequest = {
  //     id: this.travelRequestId,
  //     fromDate: '2023-06-10',
  //     toDate: '2023-06-15',
  //     location: 'Kolkata',
  //     purpose: 'Business Trip',
  //     priority: 'High',
  //     approved: true,
  //     budget: 1500,
  //     modeOfTravel: 'Air',
  //     hotelStarRating: '5'
  //   };
  // }

  submitApproval() {
    // Perform the logic to submit the approval
    // Replace this with your own logic or API call

    // Display an acknowledgement to the HR
    alert('Approval submitted successfully!');
  }
}

