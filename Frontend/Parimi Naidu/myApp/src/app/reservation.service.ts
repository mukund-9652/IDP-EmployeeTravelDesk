import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { reservations } from './reservation';
import { map } from 'rxjs/operators';

//import { Reservations } from '../models/Reservations.model';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  private baseUrl = 'http://localhost:8089/api/reservations';

  constructor(private http: HttpClient) { }

  getReservationsByTravelRequestId(travelRequestId: number): Observable<reservations[]> {
    const url = `${this.baseUrl}/track/${travelRequestId}`;
    return this.http.get<reservations[]>(url);
  }

  getReservationById(reservationId: number):any {
    const url = "http://localhost:8089/api/reservations/";
    return this.http.get(url + reservationId).pipe(map(res => res));
  }

  addReservation(reservationsDTO: reservations): Observable<void> {
    const url = `${this.baseUrl}/add`;
    return this.http.post<void>(url, reservationsDTO);
  }
}
