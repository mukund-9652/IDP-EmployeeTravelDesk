import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { ChangeGradeComponent } from './change-grade/change-grade.component';

const routes: Routes = [
  { path:'',redirectTo:'users',pathMatch:'full'},
  { path:'users',component:EmployeeListComponent},
  { path:'add',component:AddEmployeeComponent},
  { path:'grade',component:ChangeGradeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
