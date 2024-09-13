import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { API_URL } from '../app.url.dev';
import { UserAuth } from './auth';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class SecurityService {

  constructor(
    private router: Router,
    private httpClient: HttpClient) { }

  register(userAuth: UserAuth){
    return this.httpClient.post(`${API_URL}auth/register`,userAuth);
  }

  login(userAuth: UserAuth){
    return this.httpClient.post(`${API_URL}auth/login`,userAuth);
  }

  redirect(){
    this.router.navigate([`signin`]);
  }


}
