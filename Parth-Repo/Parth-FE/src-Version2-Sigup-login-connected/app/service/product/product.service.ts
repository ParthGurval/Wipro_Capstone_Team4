import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from 'src/app/model/Product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) { }

  baseURL:string = 'http://localhost:8989/api/products';


  insertCustomer(body:Product):Observable<Product> {

    console.log(body);
    return this.http.post<Product>(this.baseURL +"/createProduct", body);
  }

  updateCustomer(productId:number, body:Product):Observable<Product> {

    console.log(body);
    return this.http.put<Product>(this.baseURL + "/updateProduct/" + productId, body);
  }

  findCustomer(productId:number):Observable<Product> {

    console.log("Find ProductId: " + productId)
    return this.http.get<Product>(this.baseURL +"/getProductById/"+ productId);  
  }

  getAllCustomer():Observable<Product[]> {

    return this.http.get<Product[]>(this.baseURL +"/getAllProducts");
  }

  deleteCustomer(productId:number):Observable<string> {

    return this.http.delete<string>(this.baseURL +`/deleteProduct/${productId}`);
  }

}
