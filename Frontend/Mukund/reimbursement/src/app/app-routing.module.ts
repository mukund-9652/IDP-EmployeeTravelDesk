import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewReimbursementComponent } from './components/reimbursement-requests/new-reimbursement/new-reimbursement.component';
import { ProcessReimbursementComponent } from './components/reimbursement-requests/process-reimbursement/process-reimbursement.component';
import { ReimbursementsListComponent } from './components/reimbursement-requests/reimbursements-list/reimbursements-list.component';
import { ReimbursementTypesListComponent } from './components/reimbursement-types-list/reimbursement-types-list.component';

const routes: Routes = [
  {path:'AddNewRequest', component: NewReimbursementComponent},
  {path:'ProcessRequests', component: ProcessReimbursementComponent },
  {path:'ViewReimbursementRequests', component: ReimbursementsListComponent },
  {path:'ViewReimbursementTypes', component: ReimbursementTypesListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
