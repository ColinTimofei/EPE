import { Injectable } from '@angular/core';

export interface UserLogin {
  email: string
  password: string
}

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor() { }
}
