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

  

  getReservationsByTravelRequestId(travelRequestId: number): any {
    const url = "http://localhost:8089/api/reservations/track/";
    return this.http.get(url + travelRequestId).pipe(map(res => res));
  }

  getReservationById(reservationId: number): any {
    const url = "http://localhost:8089/api/reservations/";
    return this.http.get(url + reservationId).pipe(map(res => res));
  } 

  addReservation(reservationsDTO: reservations) {
    
  
    const url = "http://localhost:8089/api/reservations/add";
    return this.http.post(url, reservationsDTO).pipe(map((response: any) => response.json()));
    // return this.http.get(url + "/4").pipe(map(res => res));
  }
}


// import { HttpClient } from '@angular/common/http';
// import { Injectable } from '@angular/core';
// import { Observable } from 'rxjs';

// @Injectable({
//   providedIn: 'root'
// })
// export class UserService {
//   private baseUrl = 'http://localhost:8080';

//   constructor(private http: HttpClient) { }

//   getEmployeeById(id: number): Observable<any> {
//     return this.http.get(this.baseUrl + '/employee/' + id);
//   }

//   insertEmployee(user: Object): Observable<object> {
//     return this.http.post(this.baseUrl + '/employees', user);
//   }

//   updateEmployee(user:object,id:number): Observable<object> {
//     return this.http.put(this.baseUrl + '/employees/'+ id,user);
//   }

//   deleteEmployeeById(id: number): Observable<any> {
//     return this.http.delete(this.baseUrl + '/employees/' + id);
//   }

//   getAllUsers(): Observable<any> {
//     return this.http.get(this.baseUrl + '/employees');
//   }
// }