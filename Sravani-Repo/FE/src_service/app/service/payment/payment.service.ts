import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Payment } from 'src/app/model/Payment';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  private apiUrl = 'http://localhost:8082/api/payments'; 

  constructor(private http: HttpClient) {}

  
  createPayment(payment: Payment): Observable<Payment> {
    return this.http.post<Payment>(`${this.apiUrl}/createPayment`, payment);
  }


  getPaymentById(paymentId: number): Observable<Payment> {
    console.log("Payment Details ID Fetched: " + paymentId);
    return this.http.get<Payment>(`${this.apiUrl}/getbyid/${paymentId}`);
  }

 
  getAllPayments(): Observable<Payment[]> {
    return this.http.get<Payment[]>(`${this.apiUrl}/getallPayments`);
  }


  updatePayment(payment: Payment): Observable<Payment> {
    return this.http.put<Payment>(`${this.apiUrl}/updatePayment`, payment);
  }

  deletePayment(paymentId: number): Observable<string> {
    return this.http.delete<string>(`${this.apiUrl}/deletebyid/${paymentId}`);
  }
}
