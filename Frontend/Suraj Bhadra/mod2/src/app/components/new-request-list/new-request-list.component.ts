import { Component } from '@angular/core';

@Component({
  selector: 'app-new-request-list',
  templateUrl: './new-request-list.component.html',
  styleUrls: ['./new-request-list.component.css']
})
export class NewRequestListComponent {
  travelRequests: any[] = [
    { id: 'TRID001', fromDate: '2023-06-10', toDate: '2023-06-15', location: 'Kolkata', purpose: 'Business Trip', priority: 'High' },
    { id: 'TRID002', fromDate: '2023-06-20', toDate: '2023-06-25', location: 'Pune', purpose: 'Conference', priority: 'Medium' },
    // Add more travel requests as needed
  ];

  constructor() {}

  approveRequest(requestId: string) {
    // Perform the necessary logic to approve the request

    // Redirect to the travel request details component with the request ID as a route parameter
    // this.router.navigate(['/travel-request-details', requestId]);
  }

  rejectRequest(requestId: string) {
    // Perform the necessary logic to reject the request
  }
}
