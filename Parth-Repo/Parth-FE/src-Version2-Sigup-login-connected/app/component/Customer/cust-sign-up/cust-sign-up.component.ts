import { Component, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'src/app/model/customer';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-cust-sign-up',
  templateUrl: './cust-sign-up.component.html',
  styleUrls: ['./cust-sign-up.component.css']
})
export class CustSignUpComponent {
  @ViewChild('signupForm') signupForm!: NgForm; // Access the form
  customer: Customer = new Customer();

  constructor(private router: Router) {}

  onSignupSubmit() {
    // Here, you would send the 'customer' object to your backend API to create a new account
    console.log('Customer Data:', this.customer);
  }

  onClear() {
    // Reset the form using resetForm method
    this.signupForm.resetForm();
  }
}
