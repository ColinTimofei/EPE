import { UserLogin } from './../login-service/login.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  user?: UserLogin

  constructor() { 
    this.createNewEmptyUser()
  }

  createNewEmptyUser() {
    this.user = {
      email: '',
      password: ''
    }
  }

  login() {
    console.log(this.user)
  }

}
