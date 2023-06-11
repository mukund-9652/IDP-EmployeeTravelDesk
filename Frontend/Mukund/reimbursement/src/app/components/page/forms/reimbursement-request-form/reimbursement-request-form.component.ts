import { Component } from '@angular/core';
import { ReimbursementTypesService } from 'src/app/services/reimbursement-types.service';
import { ReimbursementRequests } from 'src/app/common/reimbursement-requests';
@Component({
  selector: 'app-reimbursement-request-form',
  templateUrl: './reimbursement-request-form.component.html',
  styleUrls: ['./reimbursement-request-form.component.css']
})
export class ReimbursementRequestFormComponent {
  reimbursementTypes: any[] = [];

  today: Date = new Date();
  randomInt: number = Math.floor(Math.random() * (1000 - 1 + 1)) + 1;

  reimbursementRequests: any = {
    documentUrl: '',
    id: this.randomInt,
    invoiceAmount: 0,
    invoiceDate: new Date(),
    invoiceNo: null,
    reimbursementTypeId: this.reimbursementTypes.at(0),
    remarks: '',
    requestDate: new Date(this.today.getFullYear(), this.today.getMonth(), this.today.getDate()),
    requestProcessedByEmployeeId: null,
    requestProcessedOn: null,
    requestRaisedByEmployeeId: null,
    status: 'New',
    travelRequestId: null
  };


  constructor(private reimbursementService: ReimbursementTypesService) {

  }

  selectedReimbursementOption: string = '';

  ngOnInit(): void {
    //console.log(this.reimbursementRequests);
    this.listReimbursementTypes();
  }

  listReimbursementTypes() {
    this.reimbursementService.getReimbursementTypesList().subscribe(
      (types: any[]) => {
        this.reimbursementTypes = types;
      },
      (error) => {
        console.error('Error fetching reimbursement types:', error);
      }
    );
  }

  postRequest() {
    console.log(this.reimbursementTypes);
  }
  onOptionSelected(event: any) {
    this.reimbursementRequests.reimbursementTypeId = this.reimbursementTypes.at((this.selectedReimbursementOption as unknown as number) - 1);
  }

}
