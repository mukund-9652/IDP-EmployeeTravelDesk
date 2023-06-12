import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReimbursementTypesListComponent } from './components/reimbursement-types-list/reimbursement-types-list.component';
import {HttpClientModule} from '@angular/common/http'
import { ReimbursementTypesService } from './services/reimbursement-types.service';
import { ProcessReimbursementComponent } from './components/reimbursement-requests/process-reimbursement/process-reimbursement.component';
import { ReimbursementsListComponent } from './components/reimbursement-requests/reimbursements-list/reimbursements-list.component';
import { NewReimbursementComponent } from './components/reimbursement-requests/new-reimbursement/new-reimbursement.component';
import { NavbarComponent } from './components/page/navbar/navbar.component';
import { ReimbursementRequestFormComponent } from './components/page/forms/reimbursement-request-form/reimbursement-request-form.component';
import { FooterComponent } from './components/page/footer/footer.component';
import { IndexComponent } from './components/page/index/index.component';
import { FormsModule,  ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './components/page/login/login.component';
import { ReimbursementRequestTableComponent } from './components/page/table/reimbursement-request-table/reimbursement-request-table.component';
import { EmployeeComponent } from './components/employee/employee.component';
import { ResourceNotFoundComponent } from './components/page/resource-not-found/resource-not-found.component';
import { MessageComponent } from './components/page/Employee/message/message.component';


@NgModule({
  declarations: [
    AppComponent,
    ReimbursementTypesListComponent,
    ProcessReimbursementComponent,
    ReimbursementsListComponent,
    NewReimbursementComponent,
    NavbarComponent,
    ReimbursementRequestFormComponent,
    FooterComponent,
    IndexComponent,
    LoginComponent,
    ReimbursementRequestTableComponent,
    EmployeeComponent,
    ResourceNotFoundComponent,
    MessageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [ReimbursementTypesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
