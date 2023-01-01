import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CakeServiceService {

  constructor(private httpclient:HttpClient) { }
  BACKEND = "http://localhost:8080"

  public getCake(id){
    return this.httpclient.get(this.BACKEND + '/getCake?id='+id);
  }
  /*public putCakeIntoBasket(cake_img:string, cake_main_ingredient:string, cake_price:number, cake_quantity:number, cake_id:number, user_id:number){
    return this.httpclient.post(this.BACKEND + "/addCakeIntoBasket", {cake_img, cake_main_ingredient, cake_price, cake_quantity, cake_id,
    user_id});
  }*/
  public cakeBasket(cakeBasketModel, cake_basket, user_cakes_in_basket){
    return this.httpclient.post(this.BACKEND+'/addCakeIntoBasket?cake_basket='+cake_basket+"&user_cakes_in_basket="+user_cakes_in_basket, cakeBasketModel)
  }
  public getCakesInBasket(user_cakes_in_basket){
    return this.httpclient.get(this.BACKEND+'/userBasket?user_cakes_in_basket='+user_cakes_in_basket)
  }
  public postCakesIntoOrderDetails(orderDetails, userId){
    return this.httpclient.post(this.BACKEND+"/orderPut?userId="+userId, orderDetails);
  }
  public getOrderDetails(){
    return this.httpclient.get(this.BACKEND+"/getOrders");
  }
  public setStatus(cakeDetails, userId){
    return this.httpclient.put(this.BACKEND+"/setStatus?userId="+userId, cakeDetails);
  }
  public deleteCake(cakeId){
    return this.httpclient.delete(this.BACKEND+"/deleteFromBasket?cakeId="+cakeId)
  }
  public changeQuantity(cakeDetails, userId){
    return this.httpclient.put(this.BACKEND+"/setQuantity?userId="+userId, cakeDetails)
  }
  public getOrders(userName){
    return this.httpclient.get(this.BACKEND+"/checkOrders?userName="+userName)
  }
  public deleteFromOrders(orderId){
    return this.httpclient.delete(this.BACKEND+"/deleteFromOrders?orderId="+orderId)
  }
}
