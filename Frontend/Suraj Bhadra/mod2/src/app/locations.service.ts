import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LocationsDTO } from './locations.js';
//import { LocationsDTO } from '../models/locations.dto';

@Injectable({
  providedIn: 'root'
})
export class LocationsService {
  private baseUrl = 'http://localhost:8082/api/travelrequests';

  constructor(private http: HttpClient) { }

  getLocations(): Observable<LocationsDTO[]> {
    return this.http.get<LocationsDTO[]>(`${this.baseUrl}/locations`);
  }
}
