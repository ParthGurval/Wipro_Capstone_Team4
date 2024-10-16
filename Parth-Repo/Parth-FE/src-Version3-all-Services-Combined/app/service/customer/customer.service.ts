import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cart } from 'src/app/model/Cart';
import { Customer } from 'src/app/model/customer';
import { Order } from 'src/app/model/Order';
import { Payment } from 'src/app/model/Payment';
import { Product } from 'src/app/model/Product';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http:HttpClient) { }

  baseURL:string = 'http://localhost:8787/api/customers';

  insertCustomer(body:Customer):Observable<Customer> {

    console.log(body);
    return this.http.post<Customer>(this.baseURL +"/createCustomer", body);
  }

  updateCustomer(customerId:number, body:Customer):Observable<Customer> {

    console.log(body);
    return this.http.put<Customer>(this.baseURL + "/updateCustomer/" + customerId, body);
  }

  findCustomer(customerId:number):Observable<Customer> {

    console.log("Find CustomerId: " + customerId)
    return this.http.get<Customer>(this.baseURL +"/getCustById/"+ customerId);  
  }

  getAllCustomer():Observable<Customer[]> {

    return this.http.get<Customer[]>(this.baseURL +"/getAllCustomer");
  }

  deleteCustomer(customerId:number):Observable<string> {

    return this.http.delete<string>(this.baseURL +`/deleteById/${customerId}`);
  }

  addProdToCart(body:Cart):Observable<Cart> {

    console.log(body);
    return this.http.post<Cart>(this.baseURL + "/addProductToCart", body);
  }

  updateCart(cart_id:number, body:Cart):Observable<Cart> {

    console.log(body);
    return this.http.post<Cart>(this.baseURL + "/updateCart/" + cart_id, body);
  }

  findCartId(cart_id:number):Observable<Cart> {

    console.log("Find Cart Id: " + cart_id);
    return this.http.get<Cart>(this.baseURL +"/getCartId/"+ cart_id); 
  }

  removeCart(cart_id:number):Observable<String> {

    return this.http.delete<string>(this.baseURL +`/removeCart/${cart_id}`);
  }

  createOrder(body:Order):Observable<Order> {

    console.log(body);
    return this.http.post<Order>(this.baseURL + "/createOrder", body);
  }

  createPayment(body:Payment):Observable<Payment> {

    console.log(body);
    return this.http.post<Payment>(this.baseURL + "/createPayment", body);
  }

  getProductId(productId:number):Observable<Product> {

    console.log("Find ProductId with CustomerApi: " + productId)
    return this.http.get<Product>(this.baseURL +"/getProductById/"+ productId);  
  }

  getAllProduct():Observable<Product[]> {

    return this.http.get<Product[]>(this.baseURL +"/getAllProducts");
  }

}
