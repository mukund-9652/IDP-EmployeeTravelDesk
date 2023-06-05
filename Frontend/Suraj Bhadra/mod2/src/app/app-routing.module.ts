import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TravelRequestDetailsComponent } from './components/travel-request-details/travel-request-details.component';
import { NewRequestListComponent } from './components/new-request-list/new-request-list.component';
import { NewTravelRequestComponent } from './components/new-travel-request/new-travel-request.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  {
    path:'',
    component:HomeComponent,
    pathMatch:'full',
  },
  {
    path:'new-travel-request',
    component:NewTravelRequestComponent,
    pathMatch:'full',
  },
  {
    path:'new-request-list',
    component:NewRequestListComponent,
    pathMatch:'full',
  },
  {
    path:'travel-request-details',
    component:TravelRequestDetailsComponent,
    pathMatch:'full',
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
