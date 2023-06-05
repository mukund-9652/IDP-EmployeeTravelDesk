import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ReservationTypes } from 'path/to/reservation-types.model';

@Injectable({
  providedIn: 'root'
})
export class ReservationTypesService {
  private baseUrl = 'http://localhost:8080/types';

  constructor(private http: HttpClient) { }

  getAllReservationTypes(): Observable<ReservationTypes[]> {
    return this.http.get<ReservationTypes[]>(this.baseUrl);
  }
}
