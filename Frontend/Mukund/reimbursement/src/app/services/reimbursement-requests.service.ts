import { Injectable } from '@angular/core';
import { ReimbursementRequests } from '../common/reimbursement-requests';
import { HttpClient, HttpErrorResponse, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { catchError, map, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReimbursementRequestsService {

  private baseUrl = 'http://localhost:8084/api/reimbursements/'
  constructor(private httpClient: HttpClient) { }

  getReimbursementRequestById(id: number): any {
    const data: any = this.httpClient.get<any>(this.baseUrl + id);

    return data;
  }

  getReimbursementRequestByTravelRequestId(id: number): Observable<ReimbursementRequests[]> {
    return this.httpClient.get<any[]>(this.baseUrl + id + "/requests");

  }

  getReimbursementRequestByEmployeeId(id: number): Observable<ReimbursementRequests[]> {
    return this.httpClient.get<any[]>(this.baseUrl + "id:" + id);
  }
  statusCode: number = 0;

  addReimbursementRequest(reimbursementRequest: ReimbursementRequests): Observable<number> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.httpClient.post<void>(this.baseUrl + 'add', reimbursementRequest, { headers, observe: 'response' }).pipe(
      map((response: HttpResponse<void>) => {
        const statusCode: number = response.status;
        // Handle the status code as needed
        if (statusCode === 201) {
          console.log('Reimbursement created successfully');
        } else {
          console.log('Error creating reimbursement');
        }
        return statusCode; // Return the status code
      }),
      catchError((error: HttpErrorResponse) => {
        // Handle the error response
        console.error('Error creating reimbursement:', error.message)
        return throwError(500);
      })
    );
  }

  updateReimbursementRequest(reimbursementRequest: ReimbursementRequests, id: number): Observable<number> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    console.log(this.baseUrl+id+'/process')
    return this.httpClient.put<void>(this.baseUrl +id+'/process', reimbursementRequest, { headers, observe: 'response' }).pipe(
      map((response: HttpResponse<void>) => {
        const statusCode: number = response.status;
        // Handle the status code as needed
        if (statusCode === 201) {
          console.log('Reimbursement updated successfully');
        } else {
          console.log('Error updating reimbursement');
        }
        return statusCode; // Return the status code
      }),
      catchError((error: HttpErrorResponse) => {
        // Handle the error response
        console.error('Error updating reimbursement:', error.message)
        return throwError(500);
      })
    );
  }
  getRequestStatus(): number {
    console.log(this.statusCode)
    return this.statusCode;
  }
}
