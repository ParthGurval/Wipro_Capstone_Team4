import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { OrderDetails } from 'src/app/model/OrderDetail';

@Injectable({
  providedIn: 'root'
})
export class OrderDetailsService {

  // Define the base URL for your API
  private apiUrl = 'http://localhost:8081/api/orderItems'; 

  constructor(private http: HttpClient) {}

 
  createOrderDetails(orderDetails: OrderDetails): Observable<OrderDetails> {
    return this.http.post<OrderDetails>(`${this.apiUrl}/createOrderItem`, orderDetails);
  }

  
  getOrderDetailsById(orderDetailsId: number): Observable<OrderDetails> {
    console.log("Order Details ID Fetched: " + orderDetailsId);
    return this.http.get<OrderDetails>(this.apiUrl + "/getbyid/" + orderDetailsId);
  }

  getAllOrderDetails(): Observable<OrderDetails[]> {
    return this.http.get<OrderDetails[]>(`${this.apiUrl}/getallOrderItems`);
  }

 
  updateOrderDetails(orderDetails: OrderDetails): Observable<OrderDetails> {
    return this.http.put<OrderDetails>(`${this.apiUrl}/updateOrderItem`, orderDetails);
  }

  
  deleteOrderDetails(orderDetailsId: number): Observable<string> {
    return this.http.delete<string>(`${this.apiUrl}/deletebyid/${orderDetailsId}`);
  }
}
