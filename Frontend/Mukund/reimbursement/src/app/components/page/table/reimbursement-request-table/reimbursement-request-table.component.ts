import { Component, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { ReimbursementRequestsService } from 'src/app/services/reimbursement-requests.service';

@Component({
  selector: 'app-reimbursement-request-table',
  templateUrl: './reimbursement-request-table.component.html',
  styleUrls: ['./reimbursement-request-table.component.css']
})
export class ReimbursementRequestTableComponent {
  pathVariable: string | null = '';
  @Input() id!: number;
  @Input() selectedOption!: string;
  reimbursementRequest!: any;
  reimbursementRequests: any[] = [];
  isDataAvailable: boolean = false;
  showError: boolean = false;
  errorMessage: string = '';

  constructor(private _activatedRoute: ActivatedRoute, private reimbursementRequestsService: ReimbursementRequestsService) { }

  ngOnInit() {
    if (this.selectedOption === 'travelRequestId') {
      this.getTravelRequestIdData(this.id);

    } else if (this.selectedOption === 'reimbursementRequestId') {
      this.getReimbursementRequestIdData(this.id);
    }
  }

  getTravelRequestIdData(travelRequestId: number) {
    if (this.id) {
      // API call and data retrieval
      this._activatedRoute.paramMap.subscribe(params => {

        this.pathVariable = params.get('travelRequestId');
        // Perform actions specific to 'TravelRequests' route
        id: <number><unknown>this.pathVariable;
      });

      this.reimbursementRequestsService.getReimbursementRequestByTravelRequestId(this.id).subscribe(
        (requests: any[]) => {
          this.isDataAvailable = true;
          this.reimbursementRequests = requests;
          console.log(this.reimbursementRequests);
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
          this.showError = true;
        }
      )
    } else {
      this.isDataAvailable = false;

      this.errorMessage = 'Travel Request Id not available';
      this.showError = true;
    }
  }

  getReimbursementRequestIdData(reimbursementRequestId: number) {
    if (this.id) {
      this._activatedRoute.paramMap.subscribe(params => {
        this.pathVariable = params.get('reimbursementRequestId');
        id: <number><unknown>this.pathVariable;
      });

      this.reimbursementRequestsService.getReimbursementRequestById(this.id).subscribe(
        (request: any) => {
          this.isDataAvailable = true;
          this.reimbursementRequest = request;
          this.reimbursementRequests = [request];
          console.log(this.reimbursementRequest);
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
          this.showError = true;
        }
      )
    } else {
      this.isDataAvailable = false;

      this.errorMessage = 'Reimbursement Request Id not available';
      this.showError = true;
    }

    if (this.reimbursementRequests.length > 0) {
      this.isDataAvailable = true;
    }
    else {
      this.isDataAvailable = false;
    }
  }
}
