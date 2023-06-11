import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ReimbursementRequests } from 'src/app/common/reimbursement-requests';
import { ReimbursementRequestsService } from 'src/app/services/reimbursement-requests.service';

@Component({
  selector: 'app-reimbursements-list',
  templateUrl: './reimbursements-list.component.html',
  styleUrls: ['./reimbursements-list.component.css']
})
export class ReimbursementsListComponent {

  @Input() id!: number;
  @Input() reimbursementRequest!: ReimbursementRequests;
  @Input() reimbursementRequests: ReimbursementRequests[] = [];
  @Input() selectedOption: string = 'travelRequestId';
  showContent: boolean = false;
  showError: boolean=false;
  submitClicked=false;
  errorMessage:string='';
  constructor(private _activatedRoute: ActivatedRoute,

  ) { }

  ngOnInit() {

  }

  onOptionChange(option: string) {
    this.selectedOption = option;
    this.showContent = false;
  }


  onSearch() {
    this.showContent = false;
    this.submitClicked = false;
    this.showError=false;

    if (this.selectedOption === 'travelRequestId' && this.id>0) {
      this.showContent = true;

    } else if (this.selectedOption === 'reimbursementRequestId'  && this.id>0) {
      this.showContent = true;

    } else {
      this.errorMessage='Id Must be greater than 0';
      this.showError=true;
    }
  }
}
