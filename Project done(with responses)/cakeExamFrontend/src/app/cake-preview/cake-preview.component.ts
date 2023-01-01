import { NgForOf } from '@angular/common';
import { ThisReceiver } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CakeServiceService } from 'src/services/cake-service.service';
import { UserAuthService } from 'src/services/user-auth.service';
import { UserServiceService } from 'src/services/user-service.service';

@Component({
  selector: 'app-cake-preview',
  templateUrl: './cake-preview.component.html',
  styleUrls: ['./cake-preview.component.css']
})
export class CakePreviewComponent implements OnInit {

  constructor(private cakeService:CakeServiceService,
    private activatedroute:ActivatedRoute,
    private userInfo:UserAuthService,
    private userRoles: UserServiceService,
    private router:Router) { }
    roles = this.userInfo.getRoles();
    userName = this.userInfo.getUserName()
  cakeDetails = {
    id: 1,
    cakeName: "",
    mainIngredient: "",
    price: 1,
    imageUrl: "",
  };
  cakeBasketDetails = {
    cake_img: "",
    cake_main_ingredient: "",
    cake_name: "",
    cake_price: 0,
    cake_quantity: 1,
    candle: 0
  }
  CuserId= 1;
  ngOnInit(): void {
    this.getParam()
    this.getId()
    console.log(this.userName);
    
  }
  public getParam(){
    this.activatedroute.queryParams.subscribe(params => {
      this.getCakePrev(params.id)
  });
  }
  public getCakePrev(id){
    console.log("function called");
    
    this.cakeService.getCake(id).subscribe(
      (resp:any) =>{
        this.cakeDetails.id = resp.id;

        this.cakeDetails.cakeName = resp.cakeName;
        this.cakeDetails.imageUrl = resp.imageUrl;
        this.cakeDetails.mainIngredient = resp.mainIngredient;
        this.cakeDetails.price = resp.price
      },
      (err) =>{
        console.log(err);
      }
    )
  }
  public getId(){
    const id = this.userInfo.getUserId();
    
    return Number(id);
  }
  public cakeBasket(cakeForm:NgForm){
    console.log(typeof this.cakeDetails.id);
    console.log(typeof this.getId());
    console.log(this.roles);
    if(this.roles == "USER" || this.roles == "ADMIN"){
      const button = document.getElementById("mybutton") as HTMLButtonElement | null;
      this.cakeService.cakeBasket(cakeForm.value, this.cakeDetails.id, this.getId()).subscribe(
        (resp:any) =>{
          this.cakeDetails.id = resp.cake_basket;
          this.CuserId = this.getId();
          this.sendAlert();
          button.setAttribute('disabled','')
        },
        (err) =>{
          console.log(err);
        }
      ); 
    }
    else{
      this.router.navigate(["loginPage"])
      window.alert("Vásárláshoz előbb kérjük jelentkezzen be.")

    } 
  }
  public sendAlert(){
    return window.alert("Sikeres kosárhoz hozzáadás!")
  }
}
