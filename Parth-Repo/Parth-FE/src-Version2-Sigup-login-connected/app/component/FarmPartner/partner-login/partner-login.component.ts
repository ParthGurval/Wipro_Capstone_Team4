import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-partner-login',
  templateUrl: './partner-login.component.html',
  styleUrls: ['./partner-login.component.css']
})
export class PartnerLoginComponent {

  // constructor(private router: Router) {}

  // navigateToSignUp() {
  //   this.router.navigate(['farmPartner/signup']);
  // }

  email: string = '';
  password: string = '';

  constructor(private router: Router) {}

  onLoginSubmit() {
    // Here, you would call a service to authenticate the user using the email and password
    console.log('Logging in with email:', this.email, 'and password:', this.password);
  }

  navigateToSignup() {
    // Redirect to the Sign Up page
    this.router.navigate(['farmPartner/signup']);
  }
}
