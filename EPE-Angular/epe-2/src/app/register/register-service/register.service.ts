import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export interface NewUser {
  firstname: string
  lastname: string
  email: string
  phone: string
  password: string
  confirm_pasword: string
}

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  url: string = 'http://localhost:8100/clients'

  constructor(private http: HttpClient) { }
}
