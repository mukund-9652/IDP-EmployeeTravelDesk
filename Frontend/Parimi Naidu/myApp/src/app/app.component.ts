import { Component, OnInit } from '@angular/core';
import { ReservationService } from './reservation.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  constructor(private ReservationService:ReservationService){

  }
  title = 'myApp';

  ngOnInit():void {
    // this.ReservationService.getReservationById().subscribe
    // (data)=>{
      // this.myApp =data 
    }
  }

