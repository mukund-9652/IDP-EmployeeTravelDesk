import { Injectable } from '@angular/core';
import { User } from '../common/interface/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private isInUser: boolean=true;
  private users:User[]=[{
    emailId:'mukund@cognizant.com',
    password:'privatePassword123!'
  }];
  constructor() { }

  isLoggedInUser():boolean{
    return this.isInUser;
  }

  validateLogin(newUser:User) : void{
    this.users.map((user)=>{
      if(user.emailId === newUser.emailId && user.password === newUser.password){
        this.isInUser=true;
      }
    });
  }
}
