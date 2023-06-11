import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/common/interface/user';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  private checkStatus:boolean=false;
  constructor(private formBuilder: FormBuilder, private loginService:LoginService,private router: Router) {
    
  } 
  login: FormGroup = this.formBuilder.group({

    emailId: ['', [Validators.required]],
    password: ['']
  });

  handleSubmit() {
    //console.log('here');
    const user : User = this.login.value;

    console.log(user);

    this.loginService.validateLogin(user);

    this.checkStatus=this.loginService.isLoggedInUser();

    if(this.checkStatus){
      this.router.navigate(['/Employee']);
    }
  }
}
