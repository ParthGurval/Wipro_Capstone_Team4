import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cust-login',
  templateUrl: './cust-login.component.html',
  styleUrls: ['./cust-login.component.css']
})
export class CustLoginComponent {

  // constructor(private router: Router) {}

  // navigateToSignUp() {
  //   this.router.navigate(['customer/signup']);
  // }

  navigateToAdmin() {
    this.router.navigate(['/admin/login']);
  }

  navigateToFarmPartner() {
    this.router.navigate(['farmPartner/login'])
  }

  email: string = '';
  password: string = '';

  constructor(private router: Router) {}

  onLoginSubmit() {
    // Here, you would call a service to authenticate the user using the email and password
    console.log('Logging in with email:', this.email, 'and password:', this.password);
  }

  navigateToSignup() {
    // Redirect to the Sign Up page
    this.router.navigate(['customer/signup']);
  }
}
