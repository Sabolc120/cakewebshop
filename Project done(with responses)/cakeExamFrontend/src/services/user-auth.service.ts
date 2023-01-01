import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserAuthService {

  constructor() { }
  
  public setRoles(authorities:[]){
    localStorage.setItem("authorities",JSON.stringify(authorities));
  }
  public getRoles(){
    return JSON.parse(localStorage.getItem("authorities")); 
  }
  public setUserName(username){
    localStorage.setItem("username",JSON.stringify(username))
  }
  public getUserName(){
    return JSON.parse(localStorage.getItem("username"))
  }
  public setToken(jwtToken:string){    
    localStorage.setItem("jwtToken", jwtToken);
  }
  public setIdUser(id){
    localStorage.setItem("id", id)
  }
  public getUserId(){
    return parseFloat(JSON.parse(localStorage.getItem("id")))
  }
  public getToken():string{
   return localStorage.getItem("jwtToken");
  }
  public clear(){
    localStorage.clear();
  }
  public isLoggedIn(){
    return this.getRoles() && this.getToken();
  }
}
