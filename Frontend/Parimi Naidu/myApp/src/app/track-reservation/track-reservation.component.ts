import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ReservationService } from '../reservation.service';

interface Reservation {
  id: number;
reservationDoneByEmployeeId: number;
travelRequestId: number;
reservationTypes: string;
createdOn: Date;
reservationDoneWithEntity: string;
reservationDate: Date;
amount: number;
confirmationId: string;
remarks: string;
}

@Component({
  selector: 'app-track-reservation',
  templateUrl: './track-reservation.component.html',
  styleUrls: ['./track-reservation.component.css']
})
export class TrackReservationComponent {

  trackName: string = '';
  // id: number;
  date: string = '';
  time: string = '';
  searchTrack:string = '';
  searchText: string = '';
  reservations!: Reservation;

  constructor(private router: Router, private reservationService: ReservationService) { }

  reserveTrack() {
    // Implement your logic here to reserve the track
    console.log('Track reserved:', this.trackName);
    console.log('Date:', this.date);
    console.log('Time:', this.time);

    // You can make API calls or perform other actions as needed
    // For simplicity, I'm just logging the values to the console
  }

  searchReservation(){

  }

  searchReservationByTravelRequestId() {
    this.reservationService.getReservationById(Number(this.searchText)).subscribe(
      (res: any) => this.reservations = res
    );

    // Implement your logic here to search for track reservations based on the searchText
    // console.log('Searching track reservations:', this.searchText);

    // You can make API calls or perform other actions as needed
    // For simplicity, I'm just logging the search text to the console
    // this.reservations = [
    //   { id: 1, trackName: 'Track 1', date: '2023-06-01', time: '09:00 AM' },
    //   { id: 2, trackName: 'Track 2', date: '2023-06-02', time: '02:30 PM' },
    //   { id: 3, trackName: 'Track 3', date: '2023-06-03', time: '11:45 AM' }
    // ];
  }

  viewDetails(reservationId: number) {
    // Navigate to the ReservationDetailsComponent with the reservation ID
    this.router.navigate(['/reservation-details', reservationId]);
  }
}
