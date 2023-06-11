import { Injectable } from '@angular/core';
import { ReimbursementRequests } from '../common/reimbursement-requests';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class ReimbursementRequestsService {

  reimbursementRequests: ReimbursementRequests[] = [];

  private baseUrl = 'http://localhost:8084/api/reimbursements/'
  constructor(private httpClient: HttpClient) { }

  getReimbursementRequestById(id: number): any {
    return this.httpClient.get<any>(this.baseUrl + id);

  }

  getReimbursementRequestByTravelRequestId(id: number): Observable<ReimbursementRequests[]> {
    return this.httpClient.get<any[]>(this.baseUrl + id + "/requests");

  }

  addReimbursementRequest(reimbursementRequest: ReimbursementRequests): Observable<void> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.httpClient.post<void>(this.baseUrl + '/add', reimbursementRequest, { headers });
  }
}
