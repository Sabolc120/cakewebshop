import { Component, OnInit } from '@angular/core';
import { UserServiceService } from 'src/services/user-service.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {

  constructor(private userRegService:UserServiceService,
    private router:Router) { }

  registerUser(registerForm:NgForm){
    console.log(registerForm.value);
    
    this.userRegService.registerUser(registerForm.value).subscribe(
      (resp) =>{
        console.log(resp);
        this.router.navigate(['loginPage'])
      },
      (err) =>{
        console.log(err);
      }
    );
  }

  ngOnInit(): void {
  }

}
