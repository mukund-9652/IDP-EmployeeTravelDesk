import { Component } from '@angular/core';

@Component({
  selector: 'app-new-request-list',
  templateUrl: './new-request-list.component.html',
  styleUrls: ['./new-request-list.component.css']
})
export class NewRequestListComponent {
  travelRequests: any[] = [
    { id: '204', fromDate: '2023-06-24', toDate: '2023-06-27', location: 'Kolkata', purpose: 'Business Meet', priority: 'High' },
    { id: '156', fromDate: '2023-06-18', toDate: '2023-06-21', location: 'Pune', purpose: 'Conference Meet', priority: 'Medium' },
    // Add more travel requests as needed
  ];
  router: any;

  constructor() {}

  approveRequest(requestId: string) {
    // Perform the necessary logic to approve the request

    // Redirect to the travel request details component with the request ID as a route parameter
    //this.router.navigate(['/travel-request-details', requestId]);
  }

  rejectRequest(requestId: string) {
    // Perform the necessary logic to reject the request
  }
}
