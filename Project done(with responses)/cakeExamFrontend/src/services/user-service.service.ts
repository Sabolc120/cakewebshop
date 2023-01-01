import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserAuthService } from './user-auth.service';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private httpClient:HttpClient,
    private userAuth:UserAuthService) { }
  BACKEND = "http://localhost:8080";

  requestHeader = new HttpHeaders(
    {"No-Auth":"True"}
  );

  public login(loginData){
    return this.httpClient.post(this.BACKEND + "/authenticate",
     loginData, {headers: this.requestHeader})
  }
  public registerUser(user){
    return this.httpClient.post(this.BACKEND + '/register', user)
  }
  public allowed(allowedRoles) :boolean{
    const role = this.userAuth.getRoles();
    let isMatch = false;
    for(let i = 0; i < allowedRoles.length; i++){
      if(allowedRoles[i] == role){
        isMatch = true;
        return isMatch;
      }
    }
    return false;
  }
}
