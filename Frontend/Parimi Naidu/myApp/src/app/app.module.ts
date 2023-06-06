import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UploadReservationComponent } from './reservation-upload/reservation-upload.component';
import { TrackReservationComponent } from './track-reservation/track-reservation.component';
import { ReservationDetailsComponent } from './reservation-details/reservation-details.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    
    UploadReservationComponent,
    TrackReservationComponent,
    ReservationDetailsComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
