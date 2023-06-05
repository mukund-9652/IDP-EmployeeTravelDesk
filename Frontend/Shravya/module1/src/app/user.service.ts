import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getEmployeeById(id: number): Observable<any> {
    return this.http.get(this.baseUrl + '/employee/' + id);
  }

  insertEmployee(user: Object): Observable<object> {
    return this.http.post(this.baseUrl + '/employees', user);
  }

  updateEmployee(user:object,id:number): Observable<object> {
    return this.http.put(this.baseUrl + '/employees/'+ id,user);
  }

  deleteEmployeeById(id: number): Observable<any> {
    return this.http.delete(this.baseUrl + '/employees/' + id);
  }

  getAllUsers(): Observable<any> {
    return this.http.get(this.baseUrl + '/employees');
  }
}