import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdLoginComponent } from './component/Admin/ad-login/ad-login.component';
import { CustLoginComponent } from './component/Customer/cust-login/cust-login.component';
import { PartnerLoginComponent } from './component/FarmPartner/partner-login/partner-login.component';
import { ParternSignUpComponent } from './component/FarmPartner/partern-sign-up/partern-sign-up.component';
import { CustSignUpComponent } from './component/Customer/cust-sign-up/cust-sign-up.component';

const routes: Routes = [

  { path: '', redirectTo: 'customer/login', pathMatch: 'full' },

  {
    path: 'customer/login',
    component: CustLoginComponent,
  },

  {
    path: 'customer/signup',
    component: CustSignUpComponent,
  },

  {
    path: 'admin/login',
    component: AdLoginComponent,
  },

  {
    path: 'farmPartner/login',
    component: PartnerLoginComponent,
  },

  {
    path: 'farmPartner/signup',
    component: ParternSignUpComponent,
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
