import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CakePreviewComponent } from './cake-preview/cake-preview.component';
import { HandleOrdersComponent } from './handle-orders/handle-orders.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { MainPageComponent } from './main-page/main-page.component';
import { MyBasketComponent } from './my-basket/my-basket.component';
import { OrderCheckOutComponent } from './order-check-out/order-check-out.component';
import { RegisterPageComponent } from './register-page/register-page.component';

const routes: Routes = [
  {path: "mainPage", component:MainPageComponent},
  {path: "loginPage", component:LoginPageComponent},
  {path: "registerPage", component:RegisterPageComponent},
  {path: "getCake", component:CakePreviewComponent},
  {path:"myBasket", component:MyBasketComponent},
  {path:"getOrders", component:HandleOrdersComponent},
  {path:"checkOut", component:OrderCheckOutComponent},
  {path:"setStatus",component:OrderCheckOutComponent},
  {path: "", component:MainPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
