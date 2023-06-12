import { Component, ViewChild } from '@angular/core';
import { ReimbursementTypesService } from 'src/app/services/reimbursement-types.service';
import { ReimbursementRequests } from 'src/app/common/reimbursement-requests';
import { ReimbursementRequestsService } from 'src/app/services/reimbursement-requests.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-reimbursement-request-form',
  templateUrl: './reimbursement-request-form.component.html',
  styleUrls: ['./reimbursement-request-form.component.css']
})
export class ReimbursementRequestFormComponent {
  reimbursementTypes: any[] = [];
  isExecutive: boolean = true;
  today: Date = new Date();
  randomInt: number = Math.floor(Math.random() * (1000 - 1 + 1)) + 1;
  pageType: string = 'Add new';
  reimbursementRequests: any = {
    documentURL: '',
    id: this.randomInt,
    invoiceAmount: null,
    invoiceDate: new Date(),
    invoiceNo: null,
    reimbursementTypes: this.reimbursementTypes.at(0),
    remarks: '',
    requestDate: new Date(this.today.getFullYear(), this.today.getMonth(), this.today.getDate()),
    requestProcessedByEmployeeId: null,
    requestProcessedOn: null,
    requestRaisedByEmployeeId: 1001,
    status: 'New',
    travelRequestId: 9991
  };


  constructor(private reimbursementTypesService: ReimbursementTypesService, private reimbursementService: ReimbursementRequestsService, private router: Router) {

  }

  selectedReimbursementOption: string = '';
  isDisabled = false;

  @ViewChild('newReimbursementRequestForm', { static: true })
  newReimbursementRequestForm!: NgForm;

  ngOnInit(): void {
    //console.log(this.reimbursementRequests);

    if (this.router.url.includes('Process')) {
      this.pageType='Process '
      this.isDisabled = true;
      this.reimbursementRequests.status = 'Approved';
    }
    this.listReimbursementTypes();
  }

  listReimbursementTypes() {
    this.reimbursementTypesService.getReimbursementTypesList().subscribe(
      (types: any[]) => {
        this.reimbursementTypes = types;
      },
      (error) => {
        console.error('Error fetching reimbursement types:', error);
      }
    );
  }

  postRequest() {
    this.reimbursementService.addReimbursementRequest(this.reimbursementRequests);
    if (this.reimbursementService.getRequestStatus() === 201) {
      this.router.navigate(['/Success'], { queryParams: { message: "Request has been submitted successfully!!!" } });
    }
  }

  onOptionSelected(event: any) {

    this.reimbursementRequests.reimbursementTypes = this.reimbursementTypes.at((this.selectedReimbursementOption as unknown as number) - 1);
  }

  statusChange(newStatus: string) {
    this.reimbursementRequests.status = newStatus;
  }
}
