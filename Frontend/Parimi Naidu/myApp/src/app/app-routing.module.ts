import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TrackReservationComponent } from './track-reservation/track-reservation.component';
import { ReservationDetailsComponent } from './reservation-details/reservation-details.component';
import { UploadReservationComponent } from './reservation-upload/reservation-upload.component';

const routes: Routes = [
  { path: '', redirectTo: '/track-reservation', pathMatch: 'full' },
  { path: 'track-reservation', component: TrackReservationComponent },
  { path: 'reservation-details/:id', component: ReservationDetailsComponent },
  { path: 'upload-reservation', component: UploadReservationComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
