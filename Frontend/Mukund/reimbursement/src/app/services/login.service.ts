import { Injectable } from '@angular/core';
import { User } from '../common/interface/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private isInUser: boolean = true;
  private isExecutive: boolean = true;
  private isEmployee: boolean = false;
  hrId: number= 9999;
  employeeId: number = 9991;
  deskExecutive: number= 9998;
  
  
  private users: User[] = [{
    emailId: 'mukund@cognizant.com',
    password: 'privatePassword123!'
  },
  {
    emailId: 'mukund.executive@cognizant.com',
    password: 'privatePassword123!'
  },
  {
    emailId: 'mukund.hr@cognizant.com',
    password: 'privatePassword123!'
  },
];
constructor() { }

isLoggedInUser(): boolean {
  return this.isInUser;
  }

  isHrOfCompany(): boolean {
    return this.isHr;
  }

  isDeskExecutive(): boolean {
    return this.isExecutive;
  }
  isEmployeeOfCompany(): boolean {
    return this.isEmployee;
  }
  
  validateLogin(newUser: User): void {
    this.users.map((user) => {
      if (user.emailId === newUser.emailId && user.password === newUser.password) {
        if (user.emailId.includes('executive')) {
          this.isInUser = true;
          this.isExecutive = true;
        } else if (user.emailId.includes('hr')) {
          this.isInUser = true;
          this.isHr = true;
        } else if (user.emailId.includes('@cognizant.com')) {
          this.isInUser = true;
          this.isEmployee = true;
        }
        else {
          this.isInUser = false;
        }
      }
    });
  }
  private isHr: boolean = false;
}
