import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TravelRequestsDTO } from './travel-requests';
//import { TravelRequestsDTO } from '../models/travel-requests.dto';

@Injectable({
  providedIn: 'root'
})
export class TravelRequestsService {
  private baseUrl = 'http://localhost:8082/api/travelrequests/';

  constructor(private http: HttpClient) { }

  createTravelRequest(travelRequest: TravelRequestsDTO): Observable<number> {
    return this.http.post<number>(this.baseUrl+"new", travelRequest);
  }

  getPendingRequestsByHRId(HRId: number): Observable<TravelRequestsDTO> {
    return this.http.get<TravelRequestsDTO>(this.baseUrl+HRId+"/pending");
  }

  getTravelRequestById(trid: number): Observable<TravelRequestsDTO> {
    return this.http.get<TravelRequestsDTO>(this.baseUrl+trid);
  }

  updateTravelRequestById(trid: number, travelRequest: TravelRequestsDTO): Observable<string> {
    return this.http.put<string>(this.baseUrl+trid+"/update", travelRequest);
  }
}
