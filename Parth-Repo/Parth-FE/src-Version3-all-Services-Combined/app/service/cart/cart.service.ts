import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cart } from 'src/app/model/Cart';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http: HttpClient) { }

  baseURL: string = 'http://localhost:8083/api/carts';

  createCart(cart: Cart): Observable<Cart> {
    return this.http.post<Cart>(this.baseURL + "/createCart", cart);
  }
  
  getAllCarts(): Observable<Cart[]> {
    return this.http.get<Cart[]>(this.baseURL + "/getallCarts");
  }

  getCartById(cartId: number): Observable<Cart> {
    console.log("Fetching Cart ID: " + cartId);
    return this.http.get<Cart>(this.baseURL + "/getbyid/" + cartId);
  }

 
  updateCart(cart: Cart): Observable<Cart> {
    return this.http.put<Cart>(this.baseURL + "/updateCart", cart);
  }

  // Delete a cart by ID
  deleteCartById(cartId: number): Observable<string> {
    return this.http.delete<string>(this.baseURL + "/deletebyid/" + cartId);
  }

  // Add product to cart
  addProductToCart(cart: Cart): Observable<Cart> {
    return this.http.post<Cart>(this.baseURL + "/addProduct", cart);
  }

  // Update cart with a product
  updateCartWithProduct(cartId: number, cart: Cart): Observable<Cart> {
    return this.http.put<Cart>(this.baseURL + "/updateCart/" + cartId, cart);
  }

  // Remove product from cart by cart ID
  removeProductFromCart(cartId: number): Observable<void> {
    return this.http.delete<void>(this.baseURL + "/removeProduct/" + cartId);
  }

  // Get all cart items by customer ID
  getAllCartItemsByCustomerId(customerId: number): Observable<Cart[]> {
    return this.http.get<Cart[]>(this.baseURL + "/customer/" + customerId);
  }
}
