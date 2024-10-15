import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { OrderDetails } from 'src/app/model/OrderDetails';
import { Customer } from 'src/app/model/customer';
import { FarmPartner } from 'src/app/model/farmPartner';
import { OrderStatus } from 'src/app/model/OrderStatus';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private baseURL: string = 'http://localhost:8085/api/orders';

  constructor(private http: HttpClient) { }

  createOrder(orderDetails: OrderDetails): Observable<OrderDetails> {
    console.log("Creating Order: ", orderDetails);
    return this.http.post<OrderDetails>(`${this.baseURL}/createOrder`, orderDetails);
  }

 
  getOrderById(orderId: number): Observable<OrderDetails> {
    console.log("Order ID Fetched: " + orderId);
    return this.http.get<OrderDetails>(`${this.baseURL}/getbyid/${orderId}`);
  }

  
  getAllOrders(): Observable<OrderDetails[]> {
    return this.http.get<OrderDetails[]>(`${this.baseURL}/getallOrders`);
  }

  
  updateOrder(orderDetails: OrderDetails): Observable<OrderDetails> {
    console.log("Updating Order: ", orderDetails);
    return this.http.put<OrderDetails>(`${this.baseURL}/updateOrder`, orderDetails);
  }

  // Update the status of an order
  updateOrderStatus(orderId: number, status: OrderStatus): Observable<OrderDetails> {
    console.log("Updating Order Status for ID: ", orderId);
    return this.http.put<OrderDetails>(`${this.baseURL}/updateOrderStatus/${orderId}`, status);
  }

  // Delete an order by ID
  deleteOrderById(orderId: number): Observable<string> {
    return this.http.delete<string>(`${this.baseURL}/deletebyid/${orderId}`);
  }

  // Get all customers
  getAllCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(`${this.baseURL}/getAllCustomers`);
  }

  // Find customer by ID
  findCustomerById(customerId: number): Observable<Customer> {
    console.log("Customer ID Fetched: " + customerId);
    return this.http.get<Customer>(`${this.baseURL}/customer/${customerId}`);
  }

  // Get all farm partners
  getAllFarmPartners(): Observable<FarmPartner[]> {
    return this.http.get<FarmPartner[]>(`${this.baseURL}/getAllFarmPartners`);
  }

  // Find farm partner by ID
  findFarmPartnerById(partnerId: number): Observable<FarmPartner> {
    console.log("Farm Partner ID Fetched: " + partnerId);
    return this.http.get<FarmPartner>(`${this.baseURL}/farmPartner/${partnerId}`);
  }

  // Get orders by customer ID
  getOrdersByCustomerId(customerId: number): Observable<OrderDetails[]> {
    return this.http.get<OrderDetails[]>(`${this.baseURL}/customer/${customerId}`);
  }

  // Get customer by order ID
  getCustomerByOrder(orderId: number): Observable<Customer> {
    return this.http.get<Customer>(`${this.baseURL}/get/customer-oder/${orderId}`);
  }

  // Get farm partner by order ID
  getFarmPartnerByOrder(orderId: number): Observable<FarmPartner> {
    return this.http.get<FarmPartner>(`${this.baseURL}/get/farmPartner-order/${orderId}`);
  }

  // Get orders by farm partner ID
  getOrdersByFarmPartnerId(partnerId: number): Observable<OrderDetails[]> {
    return this.http.get<OrderDetails[]>(`${this.baseURL}/farmPartner/${partnerId}`);
  }
}
