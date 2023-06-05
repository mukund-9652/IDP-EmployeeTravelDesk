import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

interface Reservation {
  id: number;
  trackName: string;
  date: string;
  time: string;
  documentUrl: string;
}

@Component({
  selector: 'app-reservation-details',
  templateUrl: './reservation-details.component.html',
  styleUrls: ['./reservation-details.component.css']
})
export class ReservationDetailsComponent implements OnInit {
  reservation!: Reservation;
  
  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    const reservationId = +this.route.snapshot.params['id'];
    this.reservation = {
      id: reservationId,
      trackName: 'NaN',
      date: '10-06-2022',
      time: '10:00 PM',
      documentUrl: 'http://example.com/document.pdf',
    };
  }

  downloadReservation() {
    const link = document.createElement('a');
    link.href = this.reservation.documentUrl;
    link.download = 'reservation_document.pdf';
    link.click();
  }
}
