import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ad-login',
  templateUrl: './ad-login.component.html',
  styleUrls: ['./ad-login.component.css']
})
export class AdLoginComponent {

  email: string = '';
  password: string = '';

  constructor(private router: Router) {}

  onLoginSubmit() {
    // Here, you would call a service to authenticate the user using the email and password
    console.log('Logging in with email:', this.email, 'and password:', this.password);
  }
}
