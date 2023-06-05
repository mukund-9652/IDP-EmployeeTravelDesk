import { Component } from '@angular/core';
import { UserService } from '../user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { user } from '../user';

@Component({
  selector: 'app-change-grade',
  templateUrl: './change-grade.component.html',
  styleUrls: ['./change-grade.component.css']
})
export class ChangeGradeComponent {
  employeeId!: number;
  employee!: user;
  newGrade!: string;
  acknowledgement!: string;

  constructor(private userService: UserService,private router: Router) {}

  searchEmployee() {
    this.userService.getEmployeeById(this.employeeId).subscribe(
      (data: user) => {
        this.employee = data;
        this.newGrade = this.employee.currentGradeId.name;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  updateGrade() {
    this.employee.currentGradeId.name = this.newGrade;
    if (this.employee.currentGradeId.name == "GRADE-1") {
      this.employee.currentGradeId.id = 1;
    }
    if (this.employee.currentGradeId.name == "GRADE-2") {
      this.employee.currentGradeId.id = 2;
    }
    if (this.employee.currentGradeId.name == "GRADE-3") {
      this.employee.currentGradeId.id = 3;
    }
   
    this.userService.updateEmployee(this.employee,this.employee.employeeId).subscribe(
      (data) => {
        this.acknowledgement = 'Grade updated successfully!';
      },
      (error) => {
        console.log(error);
      }
    );
    this.userList();
  }
  userList() {
    this.router.navigate(['/users']);
  }

}
