import { Component, inject } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  isNavbarOpen = false;
  hasLoggedIn = false;
  isExecutive=false;
  isHr=false;
  isEmployee=false;
  header=''
  private loginService!: LoginService;
  constructor(){
    this.loginService = inject(LoginService);
    this.isExecutive=this.loginService.isDeskExecutive();
    this.isHr=this.loginService.isHrOfCompany();
    this.isEmployee=this.loginService.isEmployeeOfCompany();
    if(this.isExecutive){
      this.header='Travel Desk Executive';
    }
    else if(this.isEmployee){
      this.header='Employee';
    }
    else{
      this.header='HR';
    }
  }
  ngOnInit() {
    if (this.loginService.isLoggedInUser()) {
      this.hasLoggedIn = true;
    }
    else {
      this.hasLoggedIn= false;
    }
  }
  logout(){
    //console.log("logged out");
  }
  changeOnLogin(){
    if (this.loginService.isLoggedInUser()) {
      this.hasLoggedIn = true;
    }
    else {
      this.hasLoggedIn= false;
    }
  }
  toggleNavbar() {
    this.isNavbarOpen = !this.isNavbarOpen;
  }
}
