import { inject } from '@angular/core';
import { CanActivateFn } from '@angular/router';
import { LoginService } from './services/login.service';
import { AppComponent } from './app.component';

export const userAuthGuard: CanActivateFn = (route, state) => {
  
  const loginService:LoginService=inject(LoginService);
  if(loginService.isLoggedInUser()){
    
    return true;
  }
  else{
    alert('You Must Login To Access This');
    return false;
  }
};
