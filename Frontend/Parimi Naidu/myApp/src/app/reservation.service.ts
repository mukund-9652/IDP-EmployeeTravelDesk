import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
// import { Reservations } from '.services/reservations.model';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  private baseUrl = 'http://localhost:8080/reservations';
  addReservationurl = 'http://localhost:8080/api/Reservations/addreservation';
  getReservationsByTravelRequestIdurl = 'http://localhost:8080/api/Reservations/getReservationsByTravelRequestId';
  getReservationByIdurl = 'http://localhost:8080/api/Reservations/getReservationsById';
  
  statusCode: any;

  constructor(private http: HttpClient) { }

  getCommonHeaders() {
    const headers = {
        headers: new HttpHeaders({
          'Accept': new HttpHeaders({
          'Content-Type' = 'application/json'

          })
        });
        return headers;
    }
  }
  addReservation(reservations: Reservations): Observable<void> {
    return this.http.post<void>(`${this.baseUrl}/add`, reservations);
  }

  getReservationsByTravelRequestId(travelRequestId: number): Observable<Reservations[]> {
    return this.http.get<Reservations[]>(`${this.baseUrl}/track/${travelRequestId}`);
  }

  getReservationById(reservationId: number): Observable<Reservations> {
    return this.http.get<Reservations>(`${this.baseUrl}/${reservationId}`);
  }
}
