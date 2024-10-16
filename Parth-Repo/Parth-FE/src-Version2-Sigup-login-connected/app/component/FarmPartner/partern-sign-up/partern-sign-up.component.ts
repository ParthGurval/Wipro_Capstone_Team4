import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { FarmPartner } from 'src/app/model/farmPartner';
import { FarmPartnerService } from 'src/app/service/farmPartner/farm-partner.service';

@Component({
  selector: 'app-partern-sign-up',
  templateUrl: './partern-sign-up.component.html',
  styleUrls: ['./partern-sign-up.component.css']
})
export class ParternSignUpComponent {
  
  // @ViewChild('signupForm') signupForm!: NgForm; // Access the form
  // farmPartner: FarmPartner = new FarmPartner();

  // constructor(private router: Router) {}

  // onSignupSubmit() {
  //   // Here, you would send the 'customer' object to your backend API to create a new account
  //   console.log('FarmPartner Data:', this.farmPartner);
  // }

  // onClear() {
  //   // Reset the form using resetForm method
  //   this.signupForm.resetForm();
  // }

  @ViewChild('signupForm') signupForm!: NgForm; // Access the form
  farmPartner: FarmPartner = new FarmPartner(); // Create instance of FarmPartner model
  errorMessage: string = ''; // To store error message

  constructor(private farmPartnerService: FarmPartnerService, private router: Router) {}

  // Function to submit the sign-up form
  onSignupSubmit() {
    if (this.signupForm.valid) {
      // Populate farmPartner from the form
      this.farmPartner = this.signupForm.value;

      // Call the service method to insert the FarmPartner
      this.farmPartnerService.insertFarmPart(this.farmPartner).subscribe({
        next: (response) => {
          console.log('FarmPartner created:', response);
          this.router.navigate(['/farmPartner/login']); // Navigate after successful sign-up
        },
        error: (error) => {
          console.error('Error during sign-up:', error);
          this.errorMessage = 'Failed to sign up. Please try again later.';
        }
      });
    } else {
      console.log('Form is not valid');
    }
  }

  // Function to clear all form fields
  onClear() {
    this.signupForm.resetForm();
    this.errorMessage = '';
  }
}
