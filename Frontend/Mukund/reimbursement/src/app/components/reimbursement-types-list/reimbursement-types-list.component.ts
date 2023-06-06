import { Component } from '@angular/core';
import { ReimbursementTypes } from 'src/app/common/reimbursement-types';
import { ReimbursementTypesService } from 'src/app/services/reimbursement-types.service';

@Component({
  selector: 'app-reimbursement-types-list',
  templateUrl: './reimbursement-types-list.component.html',
  styleUrls: ['./reimbursement-types-list.component.css']
})
export class ReimbursementTypesListComponent {

  reimbursementTypes: any[] = [];
  constructor(private reimbursementService: ReimbursementTypesService){

  }
    ngOnInit():void{
      this.listReimbursementTypes();
    }
  listReimbursementTypes() {
    this.reimbursementService.getReimbursementTypesList().subscribe(
      (types: any[]) => {  
        this.reimbursementTypes = types;
        console.log(this.reimbursementTypes); // Verify if the data is populated correctly
      },
      (error) => {
        console.error('Error fetching reimbursement types:', error);
      }
    );
  }
}
