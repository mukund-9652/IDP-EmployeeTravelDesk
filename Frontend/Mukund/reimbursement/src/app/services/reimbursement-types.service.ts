import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { ReimbursementTypes } from '../common/reimbursement-types';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReimbursementTypesService {


  private baseUrl ='http://localhost:8084/api/reimbursements/types'
  constructor(private httpClient :HttpClient) {}

  getReimbursementTypesList(): Observable<ReimbursementTypes[]>{
      return this.httpClient.get<ReimbursementTypes[]>(this.baseUrl);

  }
}