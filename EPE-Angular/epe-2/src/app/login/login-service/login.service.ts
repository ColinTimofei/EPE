import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import {throwError as observableThrowError,  Observable } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';
import { Injectable } from '@angular/core';


export interface UserLoginRequest {
  email: string
  password: string
}

export interface UserLoginResponse {
  email: string
  token: string
}

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  url: string = 'http://localhost:8098/api/v1/auth/'

  constructor(private http: HttpClient) { }

  login(user: UserLoginRequest) {
    return this.http.post(this.url + 'login', user)
      .pipe(tap(data => {}) , catchError(this.errorHandler))
  }

  errorHandler(error: HttpErrorResponse){
    return observableThrowError(error.message || "Server Error");
  }
}
