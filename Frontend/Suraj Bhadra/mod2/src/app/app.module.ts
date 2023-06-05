import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { NewTravelRequestComponent } from './components/new-travel-request/new-travel-request.component';
import { NewRequestListComponent } from './components/new-request-list/new-request-list.component';
import { TravelRequestDetailsComponent } from './components/travel-request-details/travel-request-details.component';
import {RouterModule} from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './components/home/home.component'



@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    NewTravelRequestComponent,
    NewRequestListComponent,
    TravelRequestDetailsComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
