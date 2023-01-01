import { Component, OnInit, resolveForwardRef } from '@angular/core';
import { Router } from '@angular/router';
import { CakeServiceService } from 'src/services/cake-service.service';
import { UserAuthService } from 'src/services/user-auth.service';

@Component({
  selector: 'app-order-check-out',
  templateUrl: './order-check-out.component.html',
  styleUrls: ['./order-check-out.component.css']
})
export class OrderCheckOutComponent implements OnInit {

  constructor(private cakeService:CakeServiceService,
    private userInfo: UserAuthService) { }
  cakeBasketDetails = null;
  cakeId = 0;
  cakeToUpdate = {
    id: 1,
    cakeName: "asd",
    cakeImg: "asd",
    cakeMainIngredient:"asd",
    cakePrice: 1,
    cakeQuantity: 1,
    candle: 0,
    placedOrder: true
  };
  ngOnInit(): void {
    this.getCakesInBasket(this.userInfo.getUserId())
    
  }
  public getCakesInBasket(user_cakes_in_basket){
    return this.cakeService.getCakesInBasket(user_cakes_in_basket).subscribe(
      (resp:any) =>{
        console.log(resp);
        
        this.cakeBasketDetails = resp;
        for (let index = 0; index < this.cakeBasketDetails.length; index++) {
          console.log(resp[index].cakeName);
          
          this.cakeToUpdate.cakeName = resp[index].cakeName;
          this.cakeToUpdate.id = resp[index].cakeModel.id
          this.cakeId = this.cakeToUpdate.id = resp[index].cakeModel.id
          this.cakeToUpdate.cakeMainIngredient = resp[index].cakeMainIngredient
          this.cakeToUpdate.cakePrice = resp[index].cakePrice
          this.cakeToUpdate.cakeQuantity = resp[index].cakeQuantity
          this.cakeToUpdate.candle = resp[index].candle
          this.cakeToUpdate.cakeImg = resp[index].cakeImg
          this.setStatus(this.cakeToUpdate)
        }
        console.log(this.cakeToUpdate.id);
      },
      (err) =>{
        console.log(err);
      }
    );
  }
  setStatus(orderForm){
    //Szükséges egy update
    this.cakeService.setStatus(this.cakeToUpdate, this.userInfo.getUserId()).subscribe(
      (resp) =>{
        this.cakeToUpdate.placedOrder = true;
        console.log(resp);
        console.log(this.cakeToUpdate.id);
        //cakeId megoldva, többi propertyt is péeles
        
        //MySql hiba miatt a torta ID-ja nincsen leküldve.
      },
      (err)=>{
        console.log(err);
      }
    )
  }
}
