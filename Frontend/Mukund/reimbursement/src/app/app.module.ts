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
@NgModule({
  declarations: [
    AppComponent,
    ReimbursementTypesListComponent,
    ProcessReimbursementComponent,
    ReimbursementsListComponent,
    NewReimbursementComponent,
    NavbarComponent,
    ReimbursementRequestFormComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [ReimbursementTypesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
