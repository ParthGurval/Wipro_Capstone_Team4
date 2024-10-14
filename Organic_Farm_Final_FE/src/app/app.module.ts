import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminDashboardComponent } from './component/Admin/admin-dashboard/admin-dashboard.component';
import { AdminGetAllCustomersComponent } from './component/Admin/admin-get-all-customers/admin-get-all-customers.component';
import { AdminGetByCustIdComponent } from './component/Admin/admin-get-by-cust-id/admin-get-by-cust-id.component';
import { AdminDelCustByIdComponent } from './component/Admin/admin-del-cust-by-id/admin-del-cust-by-id.component';
import { AdminGetAllFarmPartnersComponent } from './component/Admin/admin-get-all-farm-partners/admin-get-all-farm-partners.component';
import { AdminGetFarmPartByIdComponent } from './component/Admin/admin-get-farm-part-by-id/admin-get-farm-part-by-id.component';
import { AdminDelFarmPartByIdComponent } from './component/Admin/admin-del-farm-part-by-id/admin-del-farm-part-by-id.component';
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
import { AddProductComponent } from './component/Customer/add-product/add-product.component';
import { UpdateProductComponent } from './component/Customer/update-product/update-product.component';
import { GetProductIdComponent } from './component/Customer/get-product-id/get-product-id.component';
import { GetAllProductComponent } from './component/Customer/get-all-product/get-all-product.component';
import { DeleteProductComponent } from './component/Customer/delete-product/delete-product.component';
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

@NgModule({
  declarations: [
    AppComponent,
    AdminDashboardComponent,
    AdminGetAllCustomersComponent,
    AdminGetByCustIdComponent,
    AdminDelCustByIdComponent,
    AdminGetAllFarmPartnersComponent,
    AdminGetFarmPartByIdComponent,
    AdminDelFarmPartByIdComponent,
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
    AddProductComponent,
    UpdateProductComponent,
    GetProductIdComponent,
    GetAllProductComponent,
    DeleteProductComponent,
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
    CartDashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
