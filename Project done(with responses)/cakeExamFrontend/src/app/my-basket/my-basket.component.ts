import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { last } from 'rxjs';
import { CakeServiceService } from 'src/services/cake-service.service';
import { UserAuthService } from 'src/services/user-auth.service';

@Component({
  selector: 'app-my-basket',
  templateUrl: './my-basket.component.html',
  styleUrls: ['./my-basket.component.css']
})
export class MyBasketComponent implements OnInit {
  constructor(private cakeService:CakeServiceService,
    private userInfo:UserAuthService,
    private route: Router) { }
    cakeBasketDetails = null;
    cakeId = 0;
    userName = this.userInfo.getUserName();
    cakeToUpdate = {
      id: 1,
      cakeName: "asd",
      cakeImg: "asd",
      cakeMainIngredient:"asd",
      cakePrice: 1,
      cakeQuantity: 1,
      candle: 0,
      placedOrder: false
    };
  user_cakes_in_basket_holder = 0
  user_id = 0;

  savedForm = false;
  ngOnInit(): void {
    this.getCakesInBasket(this.getId())
  }
  public getCakesInBasket(user_cakes_in_basket){
    return this.cakeService.getCakesInBasket(user_cakes_in_basket).subscribe(
      (resp:any) =>{
        this.cakeBasketDetails = resp;
        for (let index = 0; index < this.cakeBasketDetails.length; index++) {
          console.log(resp[index].cakeName);

          
          this.cakeToUpdate.cakeName = resp[index].cakeName;
          this.cakeToUpdate.id = resp[index].cakeModel.id
          this.cakeId = this.cakeToUpdate.id = resp[index].cakeModel.id
          this.cakeToUpdate.cakeMainIngredient = resp[index].cakeMainIngredient
          this.cakeToUpdate.cakePrice = resp[index].cakePrice

          this.cakeToUpdate.candle = resp[index].candle
          this.cakeToUpdate.cakeImg = resp[index].cakeImg
          this.cakeToUpdate.cakeQuantity = this.cakeBasketDetails[index].cakeQuantity;
        }
      },
      (err) =>{
        console.log(err);
      }
    );
  }
  public getId(){
    const id = this.userInfo.getUserId();
    this.user_id = id;
    return Number(id);
  }
  public sendOrder(orderForm){
    var lastName = (<HTMLInputElement>document.getElementById("lastName")).value;
    var firstName = (<HTMLInputElement>document.getElementById("firstName")).value;
    var customerPhoneNumber = (<HTMLInputElement>document.getElementById("customerPhoneNumber")).value;
    var customerEmail = (<HTMLInputElement>document.getElementById("customerEmail")).value;
    var address = (<HTMLInputElement>document.getElementById("address")).value;
    if(lastName.length == 0 || firstName.length == 0 || customerPhoneNumber.length == 0 || customerEmail.length == 0||
      address.length == 0){
      return alert("Nem minden mező lett kitöltve, kérem nézze át.")
    }
    const button = document.getElementById("mybutton") as HTMLButtonElement | null;
    return this.cakeService.postCakesIntoOrderDetails(orderForm.value, this.getId()).subscribe(
      (resp:any) =>{
        console.log(orderForm.value);
        this.savedForm = true;
        button.setAttribute('disabled','')
        
        console.log(resp);
        alert("Adatok sikeresen elmentésre kerültek.")
      },
      (err) =>{
        console.log(err);
      }
    )
  }
  refresh():void{
    window.location.reload();
  }
  public next(){

    
    const nav = this.route.navigate(["/checkOut"])
  }
  public deleteCake(cakeId){
    return this.cakeService.deleteCake(cakeId).subscribe(
      (resp:any) =>{
        console.log(resp);
        this.refresh();
      },
      (err) =>{
        console.log(err);
      }
    )
  }
  setQuantity(toUpdate : any, event: any){
    return this.cakeService.changeQuantity(toUpdate, this.getId()).subscribe(
      (resp:any) =>{
        console.log(resp);
      },
      (err) =>{
        console.log(err);
      }
    )
  }
  trackByIndex(index: number, obj: any): any {
    return index;
  }
}