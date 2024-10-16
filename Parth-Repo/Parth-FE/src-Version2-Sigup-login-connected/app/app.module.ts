import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms'; 
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminDashboardComponent } from './component/Admin/admin-dashboard/admin-dashboard.component';
import { GetAllCustComponent } from './component/Admin/get-all-cust/get-all-cust.component';
import { GetCustIdComponent } from './component/Admin/get-cust-id/get-cust-id.component';
import { DelCustomerComponent } from './component/Admin/del-customer/del-customer.component';
import { GetAllPartnerComponent } from './component/Admin/get-all-partner/get-all-partner.component';
import { GetPartIdComponent } from './component/Admin/get-part-id/get-part-id.component';
import { DelPartnerComponent } from './component/Admin/del-partner/del-partner.component';
import { AddCustomerComponent } from './component/Customer/add-customer/add-customer.component';
import { UpdateCustomerComponent } from './component/Customer/update-customer/update-customer.component';
import { GetAllCustomerComponent } from './component/Customer/get-all-customer/get-all-customer.component';
import { DelAllCustomerComponent } from './component/Customer/del-all-customer/del-all-customer.component';
import { DeleteCustomerComponent } from './component/Customer/delete-customer/delete-customer.component';
import { AddProductToCartComponent } from './component/Customer/add-product-to-cart/add-product-to-cart.component';
import { UpdateProductCartComponent } from './component/Customer/update-product-cart/update-product-cart.component';
import { DeleteProductCartComponent } from './component/Customer/delete-product-cart/delete-product-cart.component';
import { GetCartIdComponent } from './component/Customer/get-cart-id/get-cart-id.component';
import { CreateOrderComponent } from './component/Customer/create-order/create-order.component';
import { CreatePaymentComponent } from './component/Customer/create-payment/create-payment.component';
import { CustDashboardComponent } from './component/Customer/cust-dashboard/cust-dashboard.component';
import { CreateFarmPartnerComponent } from './component/FarmPartner/create-farm-partner/create-farm-partner.component';
import { UpdateFarmPartnerComponent } from './component/FarmPartner/update-farm-partner/update-farm-partner.component';
import { DeleteFarmPartnerComponent } from './component/FarmPartner/delete-farm-partner/delete-farm-partner.component';
import { GetFarmPartnerIdComponent } from './component/FarmPartner/get-farm-partner-id/get-farm-partner-id.component';
import { GetAllFarmPartnerComponent } from './component/FarmPartner/get-all-farm-partner/get-all-farm-partner.component';
import { CreateProductComponent } from './component/FarmPartner/create-product/create-product.component';
import { PartnerDashboardComponent } from './component/FarmPartner/partner-dashboard/partner-dashboard.component';
import { GetAllProductsComponent } from './component/Customer/get-all-products/get-all-products.component';
import { GetProductByIdComponent } from './component/Customer/get-product-by-id/get-product-by-id.component';
import { ProductDashboardComponent } from './component/Customer/product-dashboard/product-dashboard.component';
import { CartDashboardComponent } from './component/Customer/cart-dashboard/cart-dashboard.component';
import { AdLoginComponent } from './component/Admin/ad-login/ad-login.component';
import { CustLoginComponent } from './component/Customer/cust-login/cust-login.component';
import { CustSignUpComponent } from './component/Customer/cust-sign-up/cust-sign-up.component';
import { PartnerLoginComponent } from './component/FarmPartner/partner-login/partner-login.component';
import { ParternSignUpComponent } from './component/FarmPartner/partern-sign-up/partern-sign-up.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminDashboardComponent,
    GetAllCustComponent,
    GetCustIdComponent,
    DelCustomerComponent,
    GetAllPartnerComponent,
    GetPartIdComponent,
    DelPartnerComponent,
    AddCustomerComponent,
    UpdateCustomerComponent,
    GetAllCustomerComponent,
    DelAllCustomerComponent,
    DeleteCustomerComponent,
    AddProductToCartComponent,
    UpdateProductCartComponent,
    DeleteProductCartComponent,
    GetCartIdComponent,
    CreateOrderComponent,
    CreatePaymentComponent,
    CustDashboardComponent,
    CreateFarmPartnerComponent,
    UpdateFarmPartnerComponent,
    DeleteFarmPartnerComponent,
    GetFarmPartnerIdComponent,
    GetAllFarmPartnerComponent,
    CreateProductComponent,
    PartnerDashboardComponent,
    GetAllProductsComponent,
    GetProductByIdComponent,
    ProductDashboardComponent,
    CartDashboardComponent,
    AdLoginComponent,
    CustLoginComponent,
    CustSignUpComponent,
    PartnerLoginComponent,
    ParternSignUpComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
