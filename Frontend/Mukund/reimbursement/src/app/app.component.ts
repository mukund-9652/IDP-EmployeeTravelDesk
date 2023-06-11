import { Component, inject } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { LoginService } from './services/login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'reimbursement';

  private isLogged:boolean=false;
  private userEmail:string='';

  private loginService: LoginService=inject(LoginService);

  private setLogged(loggedUserEmail:string):void{
    this.isLogged=true;
    this.userEmail=loggedUserEmail;
  }

  ngOnChange(){
    
  }

  getLogged():boolean{
    return this.isLogged;
  }
}
