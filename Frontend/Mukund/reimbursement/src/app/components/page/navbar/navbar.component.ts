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
  private loginService!: LoginService;
  constructor(){
    this.loginService = inject(LoginService);
    this.isExecutive=this.loginService.isAdmin();
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
    console.log("logged out");
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
