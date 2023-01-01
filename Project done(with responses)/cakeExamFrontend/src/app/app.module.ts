import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { CakePreviewComponent } from './cake-preview/cake-preview.component';
import { MainPageComponent } from './main-page/main-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { FormsModule } from '@angular/forms';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { UserServiceService } from 'src/services/user-service.service';
import { AuthInterceptior } from 'src/_auth/auth.interceptor';
import { AuthGuard } from 'src/_auth/auth.guard';
import { FooterComponent } from './footer/footer.component';
import { MyBasketComponent } from './my-basket/my-basket.component';
import { HandleOrdersComponent } from './handle-orders/handle-orders.component';
import { OrderCheckOutComponent } from './order-check-out/order-check-out.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CakePreviewComponent,
    MainPageComponent,
    LoginPageComponent,
    RegisterPageComponent,
    ForbiddenComponent,
    FooterComponent,
    MyBasketComponent,
    HandleOrdersComponent,
    OrderCheckOutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule
  ],
  providers: [
    AuthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass:AuthInterceptior,
      multi: true
    },
    UserServiceService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
