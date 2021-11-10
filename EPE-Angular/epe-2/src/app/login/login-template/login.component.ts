import { UserLoginRequest, LoginService, UserLoginResponse } from './../login-service/login.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  user?: UserLoginRequest
  response?: UserLoginResponse
  errorMsg?: any

  constructor(private loginService: LoginService) { 
    this.createNewEmptyUser()
  }

  createNewEmptyUser() {
    this.user = {
      email: '',
      password: ''
    }
  }

  login() {
    if(this.user) {
      this.loginService.login(this.user).subscribe(data => {
        this.response = data as UserLoginResponse
       }, error => { 
        console.log(error) 
        this.errorMsg = error })
    }
  }
}
