import { Injectable } from '@angular/core';
import { ReimbursementRequests } from '../common/reimbursement-requests';
import { HttpClient, HttpErrorResponse, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { catchError, map, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReimbursementRequestsService {

  reimbursementRequests: ReimbursementRequests[] = [];

  private baseUrl = 'http://localhost:8084/api/reimbursements'
  constructor(private httpClient: HttpClient) { }

  getReimbursementRequestById(id: number): any {
    return this.httpClient.get<any>(this.baseUrl + id);

  }

  getReimbursementRequestByTravelRequestId(id: number): Observable<ReimbursementRequests[]> {
    return this.httpClient.get<any[]>(this.baseUrl + id + "/requests");

  }

  private statusCode: number = 0;
  addReimbursementRequest(reimbursementRequest: ReimbursementRequests): void {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    void this.httpClient.post<void>(this.baseUrl + '/add', reimbursementRequest, { headers, observe: 'response' }).pipe(
      map((response: HttpResponse<void>) => {
        // Get the status code
        this.statusCode=response.status;
        // Handle the status code as needed
        if (this.statusCode === 201) {
          console.log('Reimbursement created successfully');
        } else {
          console.log('Error creating reimbursement');
        }
      }),
      catchError((error: HttpErrorResponse) => {
        // Handle the error response
        //console.error('Error creating reimbursement:', error.message)
        return throwError(500);
      })
    ).subscribe();
  }

  getRequestStatus():number{
    return this.statusCode;
  }
}
