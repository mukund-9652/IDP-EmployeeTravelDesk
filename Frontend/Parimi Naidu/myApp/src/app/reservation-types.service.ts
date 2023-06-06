import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
//import { ReservationTypes } from '../models/reservation-types.model';
import { reservationTypes } from './reservationType';
@Injectable({
  providedIn: 'root'
})
export class ReservationTypesService {
  private baseUrl = 'http://localhost:8089/api/reservations/types';

  constructor(private http: HttpClient) { }

  getReservationTypes(): Observable<reservationTypes[]> {
    return this.http.get<reservationTypes[]>(this.baseUrl);
  }
}
