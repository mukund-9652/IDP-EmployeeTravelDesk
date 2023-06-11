import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewReimbursementComponent } from './components/reimbursement-requests/new-reimbursement/new-reimbursement.component';
import { ProcessReimbursementComponent } from './components/reimbursement-requests/process-reimbursement/process-reimbursement.component';
import { ReimbursementsListComponent } from './components/reimbursement-requests/reimbursements-list/reimbursements-list.component';
import { ReimbursementTypesListComponent } from './components/reimbursement-types-list/reimbursement-types-list.component';
import { IndexComponent } from './components/page/index/index.component';
import { LoginComponent } from './components/page/login/login.component';
import { EmployeeComponent } from './components/employee/employee.component';
import { userAuthGuard } from './user-auth.guard';
import { ResourceNotFoundComponent } from './components/page/resource-not-found/resource-not-found.component';

const routes: Routes = [
  { path: '', component: IndexComponent },
  { path: 'Login', component: LoginComponent },

  { path: 'Home', component: IndexComponent },
  {
    path: 'Employee', component: EmployeeComponent,
    canActivate:[userAuthGuard],
    children: [
      { path: 'ViewReimbursementTypes', component: ReimbursementTypesListComponent },
      { path: 'AddNewRequest', component: NewReimbursementComponent },
      { path: 'ProcessRequests', component: ProcessReimbursementComponent },
      { path: 'ViewReimbursementRequests', component: ReimbursementsListComponent },
      { path: 'ViewReimbursementRequests/ReimbursementRequest/:reimbursementRequestId', component: ReimbursementsListComponent },
      { path: 'ViewReimbursementRequests/TravelRequests/:travelRequestId', component: ReimbursementsListComponent },
      { path: '**', component: ResourceNotFoundComponent }
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
