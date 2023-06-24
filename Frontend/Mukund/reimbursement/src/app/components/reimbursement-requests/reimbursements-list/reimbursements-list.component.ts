import { Component, EventEmitter, Input, OnInit,Output,inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ReimbursementRequests } from 'src/app/common/reimbursement-requests';
import { LoginService } from 'src/app/services/login.service';
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
  @Output() processClicked: EventEmitter<void> = new EventEmitter<void>();

  showContent: boolean = false;
  showError: boolean=false;
  submitClicked=false;
  errorMessage:string='';
  isExecutive=false;
  isHr=false;
  isEmployee=false;
  employeeId=0;
  private loginService!:LoginService;

  constructor(private _activatedRoute: ActivatedRoute) { 
    this.loginService=inject(LoginService);
    this.isExecutive=this.loginService.isDeskExecutive();
    this.isHr=this.loginService.isHrOfCompany();
    this.isEmployee=this.loginService.isEmployeeOfCompany();
    this.employeeId=this.loginService.employeeId;
  }

  ngOnInit() {
    console.log(this.isExecutive);
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

  @Output() showParentContent = true;

  hideParentContent(): void {
    this.showParentContent = false;
  }
}
