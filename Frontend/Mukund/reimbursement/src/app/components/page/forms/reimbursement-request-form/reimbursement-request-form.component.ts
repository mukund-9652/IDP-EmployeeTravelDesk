import { Component, Input, ViewChild, inject } from '@angular/core';
import { ReimbursementTypesService } from 'src/app/services/reimbursement-types.service';
import { ReimbursementRequests } from 'src/app/common/reimbursement-requests';
import { ReimbursementRequestsService } from 'src/app/services/reimbursement-requests.service';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { LoginService } from 'src/app/services/login.service';
import { HttpErrorResponse } from '@angular/common/http';
@Component({
  selector: 'app-reimbursement-request-form',
  templateUrl: './reimbursement-request-form.component.html',
  styleUrls: ['./reimbursement-request-form.component.css']
})
export class ReimbursementRequestFormComponent {
  reimbursementTypes: any[] = [];

  isExecutive: boolean = false;
  isHr: boolean = false;
  isEmployee: boolean = false;

  displayForm: boolean = true;
  isSuccess!: boolean;
  isFailed: boolean = false;
  errorContent: string = '';
  today: Date = new Date();
  randomInt: number = Math.floor(Math.random() * (1000 - 1 + 1)) + 1;
  pageType: string = 'Add new';
  employeeId: number = 0;
  private loginService!: LoginService;
  errorForm: any = {
    errorTravelRequestId: '',
    errorReimbursementType: '',
    errorInvoiceNo: '',
    errorInvoiceAmount: '',
    errorInvoiceDate: '',
    errorDocumentUrl: '',
    errorStatus: '',
    errorRemarks: '',
  }
  selectedReimbursementOption: string = '';
  isDisabled = false;




  constructor(private _activatedRoute: ActivatedRoute, private reimbursementTypesService: ReimbursementTypesService, private reimbursementService: ReimbursementRequestsService, private router: Router) {
    this.loginService = inject(LoginService);

    this.isExecutive = this.loginService.isDeskExecutive();
    this.isHr = this.loginService.isHrOfCompany();
    this.isEmployee = this.loginService.isEmployeeOfCompany();
    this.employeeId = this.loginService.employeeId;

    this.reimbursementService = inject(ReimbursementRequestsService)
    this.isSuccess = false;

  }
  @Input() reimbursementRequests: any = {
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
    requestRaisedByEmployeeId: null,
    status: 'New',
    travelRequestId: null
  };

  @ViewChild('newReimbursementRequestForm', { static: true })
  newReimbursementRequestForm!: NgForm;

  ngOnInit(): void {
    if (this.loginService.isDeskExecutive()) {
      this.isExecutive = true;
    }

    if (this.loginService.isHrOfCompany()) {
      this.isExecutive = true;
    }

    if (this.loginService.isEmployeeOfCompany()) {
      this.isExecutive = true;
    }

    if (this.router.url.includes('Process')) {
      this.pageType = 'Process '
      this.isDisabled = true;
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
    if (this.checkInput()) {
      const currentUrl = this.router.url;
      const containsProcessRequest = currentUrl.includes('ProcessRequest');
      if (containsProcessRequest) {
        if (this.reimbursementRequests.status === 'New') {
          this.errorForm.errorStatus = 'Choose an Option!!'
        }
        else {
          this.errorForm.errorStatus = ''

          if (this.reimbursementRequests.status === "Rejected" && this.reimbursementRequests.remarks === "") {
            alert('Enter a remark if you are rejecting');
            this.errorForm.errorRemarks = 'Enter a remark if you are rejecting';
          }
          else {
            this.reimbursementRequests.requestProcessedOn = new Date(this.today.getFullYear(), this.today.getMonth(), this.today.getDate());
            this.reimbursementRequests.requestProcessedByEmployeeId = this.loginService.deskExecutive;
            this.reimbursementService.updateReimbursementRequest(this.reimbursementRequests, this.reimbursementRequests.id)
              .subscribe(
                (statusCode: number) => {
                  if (statusCode === 201) {
                    this.isSuccess = true;
                    this.displayForm = false;
                  }
                  else {
                    this.displayForm = false;
                    this.isFailed = true;
                  }
                }, (error: any) => {
                  if (error instanceof HttpErrorResponse) {
                    if (error.error instanceof ErrorEvent) {
                      // Client-side error
                      this.errorContent = 'An error occurred:', error.error.message;
                    } else {
                      // Server-side error
                      this.errorRaise(error.error.message);
                      this.errorContent = error.error.message;
                    }
                  } else {
                    // Other types of errors
                    this.errorContent = 'An unexpected error occurred:', error;
                  }
                }
              );
          }
        }
      }
      else {
        this.reimbursementRequests.requestRaisedByEmployeeId = this.employeeId;
        this.reimbursementService.addReimbursementRequest(this.reimbursementRequests).subscribe(
          (statusCode: number) => {
            if (statusCode === 201) {
              this.isSuccess = true;
              this.displayForm = false;
            }
            else {
              this.displayForm = false;
              this.isFailed = true;
            }
          },
          (error: any) => {
            if (error instanceof HttpErrorResponse) {
              if (error.error instanceof ErrorEvent) {
                // Client-side error
                this.errorContent = 'An error occurred:', error.error.message;
              } else {
                // Server-side error
                this.errorContent = error.error.message;
                this.errorRaise(error.error.message);
              }
            } else {
              // Other types of errors
              this.errorContent = 'An unexpected error occurred:', error;
            }
          }
        );
      }
    }else{

    }
  }

  onOptionSelected(event: any) {

    this.reimbursementRequests.reimbursementTypes = this.reimbursementTypes.at((this.selectedReimbursementOption as unknown as number) - 1);
  }

  statusChange(newStatus: string) {
    this.reimbursementRequests.status = newStatus;
  }

  errorRaise(errorMessage: string) {
    if (errorMessage.includes('Travel Request Id')) {
      this.errorForm.errorTravelRequestId = errorMessage;
    }
    else {
      this.errorForm.errorTravelRequestId = '';
    }

    if (errorMessage.includes('Invoice Number')) {
      this.errorForm.errorInvoiceNo = errorMessage;
    }
    else {
      this.errorForm.errorInvoiceNo = '';
    }

    if (errorMessage.includes('Invoice Date')) {
      this.errorForm.errorInvoiceDate = errorMessage;
    }
    else {
      this.errorForm.errorInvoiceDate = '';
    }
    if (errorMessage.includes('Invoice Amount')) {
      this.errorForm.errorInvoiceAmount = errorMessage;
    }
    else {
      this.errorForm.errorInvoiceAmount = '';
    }
    if (errorMessage.includes('Document URL')) {
      this.errorForm.errorDocumentUrl = errorMessage;
    }
    else {
      this.errorForm.errorDocumentUrl = '';
    }
    if (errorMessage.includes('Status')) {
      this.errorForm.errorStatus = errorMessage;
    }
    else {
      this.errorForm.errorStatus = '';
    }

  }

  checkInput():boolean {
    let state:boolean = false;

    if (this.reimbursementRequests.travelRequestId === '' || this.reimbursementRequests.travelRequestId===null) {
      this.errorForm.errorTravelRequestId = 'Enter Travel Request Id'
    }
    else{
      this.errorForm.errorTravelRequestId = ''
      state=true;
    }

    if (this.reimbursementRequests.invoiceNo === '' || this.reimbursementRequests.invoiceNo===null) {
      this.errorForm.errorInvoiceNo = 'Enter Invoice No.'
    }
    else{
      this.errorForm.errorInvoiceNo = ''

      state=true;
    }

    if (this.reimbursementRequests.invoiceDate === '' || this.reimbursementRequests.invoiceDate===null) {
      this.errorForm.errorInvoiceDate = 'Enter Invoice Date'
    }
    else{
      this.errorForm.errorInvoiceDate = ''
      state=true;
    }

    if (this.reimbursementRequests.invoiceAmount === 0 || this.reimbursementRequests.invoiceAmount===null) {
      this.errorForm.errorInvoiceAmount = 'Enter Invoice Amount.'
    }
    else{
      this.errorForm.errorInvoiceAmount = ''

      state=true;
    }

    if (this.reimbursementRequests.documentURL === '' || this.reimbursementRequests.documentURL===null) {
      this.errorForm.errorDocumentUrl = 'Enter DocumentUrl'
    }
    else{
      this.errorForm.errorDocumentUrl = ''
      state=true;
    }


    return state;
  }



}
