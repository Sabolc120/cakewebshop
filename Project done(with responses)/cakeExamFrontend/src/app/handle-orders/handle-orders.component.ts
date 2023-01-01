import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CakeServiceService } from 'src/services/cake-service.service';
import { UserAuthService } from 'src/services/user-auth.service';

@Component({
  selector: 'app-handle-orders',
  templateUrl: './handle-orders.component.html',
  styleUrls: ['./handle-orders.component.css']
})
export class HandleOrdersComponent implements OnInit {
  constructor(private handleOrder: CakeServiceService,
    private router:Router,
    private cakeService:CakeServiceService,
    private userInfo: UserAuthService) { }
    roles = this.userInfo.getRoles();
  orderDetails = null
  orderedStuff = null;
  ngOnInit(): void {
    this.checkRole();
    this.getOrders();
  }

  public getOrders(){
    return this.handleOrder.getOrderDetails().subscribe(
      (resp:any) =>{
        console.log(resp);
        this.orderDetails = resp;
      },
      (err) =>{
        console.log(err);
      }
    );
  }
  refresh():void{
    window.location.reload();
  }
  nav(userEmail){
   this.cakeService.getOrders(userEmail).subscribe(
    (resp:any) =>{
      this.orderedStuff = resp;
    },
    (err) =>{
      console.log(err);
    }
   )
  }
  deleteOrder(orderId){
    console.log("Function called");
    
    return this.cakeService.deleteFromOrders(orderId).subscribe(
      (resp:any) =>{
        console.log(resp);
        this.refresh();
      },
      (err) =>{
        console.log(err);
      }
    )
  }
  checkRole(){
    if(this.roles == "ADMIN"){
      return console.log("Jogszerű látogatás");
    }
    else return this.router.navigate(["mainPage"])
  }
}
