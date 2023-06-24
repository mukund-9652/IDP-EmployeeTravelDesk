import { Component, Input, inject } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ReimbursementRequestsService } from 'src/app/services/reimbursement-requests.service';
import { ReimbursementRequests } from 'src/app/common/reimbursement-requests';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-process-reimbursement',
  templateUrl: './process-reimbursement.component.html',
  styleUrls: ['./process-reimbursement.component.css']
})
export class ProcessReimbursementComponent {
  private activeRequestId=0;
  @Input() reimbursementRequests:any={};
  private errorMessage='';
  private reimbursementRequestsService!:ReimbursementRequestsService;
  constructor(private router: Router,private _activatedRoute:ActivatedRoute){
    this.reimbursementRequestsService=inject(ReimbursementRequestsService);
  }
  
  ngOnInit(){
    this._activatedRoute.paramMap.subscribe(
      params=>{
        const id=params.get('reimbursementId');
        this.activeRequestId=<number><unknown> id;
      }
      );
      this.reimbursementRequestsService.getReimbursementRequestById(this.activeRequestId).subscribe(
        (request: any) => {
          this.reimbursementRequests = request;
        },
        (error: any) => {
          if (error instanceof HttpErrorResponse) {
            if (error.error instanceof ErrorEvent) {
              // Client-side error
              this.errorMessage = 'An error occurred:', error.error.message;
            } else {
              // Server-side error
              this.errorMessage =
                `Backend returned code ${error.status}, body was: ${error.error}.`
                ;
              this.errorMessage += '\nError message: ' + error.error.message;
            }
          } else {
            // Other types of errors
            this.errorMessage = 'An unexpected error occurred:', error;
          }
        }
      );
    }
}
