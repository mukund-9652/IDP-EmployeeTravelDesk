import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { user } from '../user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  user!: Observable<user[]>;
  constructor(private userService:UserService,private router: Router){ }
ngOnInit(){
  this.EmployeeList();
}
EmployeeList(){
  this.user=this.userService.getAllUsers();
}
deleteEmployee(id:number){
  this.userService.deleteEmployeeById(id).subscribe(data=>{
    console.log(data);
    this.EmployeeList();
  },
  error=>console.log(error)
  );
}


}
