import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserAuthService } from 'src/services/user-auth.service';
import { UserServiceService } from 'src/services/user-service.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor(private userService: UserServiceService,
    private userAuthService:UserAuthService,
    private router:Router) { }

  ngOnInit(): void {
  }
  login(loginForm:NgForm){
    this.userService.login(loginForm.value).subscribe(
      (resp:any) =>{
        this.userAuthService.setRoles(resp.userModel.authorities);
        this.userAuthService.setToken(resp.jwtToken)
        this.userAuthService.setIdUser(resp.userModel.id)
        this.userAuthService.setUserName(resp.userModel.userName)
        const role = resp.userModel.authorities;
        console.log(resp);
        if(role === 'USER'){
          this.router.navigate(['mainPage'])
        }
        else if(role === 'ADMIN'){
          this.router.navigate(['mainPage']);
        }
      },
      (err) =>{
        console.log(err);
      }
    );
  }
}
