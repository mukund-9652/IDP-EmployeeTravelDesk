import { Injectable } from '@angular/core';
import { User } from '../common/interface/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private isInUser: boolean = true;
  private isExecutive: boolean = false;
  private users: User[] = [{
    emailId: 'mukund@cognizant.com',
    password: 'privatePassword123!'
  },
  {
    emailId: 'mukund.admin@cognizant.com',
    password: 'privatePassword123!'
  }];
  constructor() { }

  isLoggedInUser(): boolean {
    return this.isInUser;
  }

  isAdmin():boolean{
    return this.isExecutive;
  }

  validateLogin(newUser: User): void {
    this.users.map((user) => {
      if (user.emailId === newUser.emailId && user.password === newUser.password) {
        this.isInUser = true;
        if(user.emailId.includes('admin')){
          this.isExecutive=true;
        }
      }
    });
  }
}
