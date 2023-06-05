import { Component, OnInit } from '@angular/core';
import { user } from '../user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { grade } from '../grade';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {
  NameGrade!: number;
  constructor(private userService: UserService,private router: Router){ }
  user: user = new user();
  grade: grade = new grade();
  
  ngOnInit() {
  }
  
  onSubmit() {
    this.changeGrade();
    this.saveUser();
  }
  
  changeGrade() {
    this.grade.id = this.NameGrade;
    if(this.grade.id == 1){
      this.grade.name = "GRADE-1";
    }
    if(this.grade.id == 2){
      this.grade.name = "GRADE-2";
    }
    if(this.grade.id==3){
      this.grade.name = "GRADE-3";
    }
  }
  
  saveUser() {
    this.user.currentGradeId = this.grade;
    this.userService.insertEmployee(this.user)
      .subscribe({
        next: data => console.log(data),
        error: error => console.log(error)
      });
    this.userList();
  }
  
  userList() {
    this.router.navigate(['/users']);
  }
}
