import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FarmPartner } from 'src/app/model/farmPartner';
import { Product } from 'src/app/model/Product';

@Injectable({
  providedIn: 'root'
})
export class FarmPartnerService {

  constructor(private http:HttpClient) { }

  baseURL:string = 'http://localhost:8484/api/farmpartners';

  insertFarmPart(body:FarmPartner):Observable<FarmPartner> {

      console.log(body);
      return this.http.post<FarmPartner>(this.baseURL +"/createPartner", body);
  }

  updateFarmPart(partnerId:number, body:FarmPartner):Observable<FarmPartner> { // Here we have to featch Id also write code for it too

      console.log(body);
      return this.http.put<FarmPartner>(this.baseURL + "/updatePartner/" + partnerId, body);
  }

  // update(body:FarmPartner):Observable<FarmPartner>{ 

  //   console.log(body);
  //   return this.http.put<FarmPartner>(this.baseURL+"/updatePartner",body);
  // }

  findFarmPart(partnerId:number):Observable<FarmPartner> {

      console.log("PartnerId Find By FarmPartner Service"+partnerId)
      return this.http.get<FarmPartner>(this.baseURL +"/getbyid/"+ partnerId);  
  }

  getAllFarmPart():Observable<FarmPartner[]> {

      return this.http.get<FarmPartner[]>(this.baseURL +"/getallPartner");
  }

  deleteFarmPart(partnerId:number):Observable<string> {

    return  this.http.delete<string>(this.baseURL +`/deletebyid/${partnerId}`);
  }

  insertProduct(body:Product):Observable<Product> {

    console.log(body);
    return this.http.post<Product>(this.baseURL + "/createProduct", body);
  }

  updateProduct(productId:number, body:Product):Observable<Product> {

    console.log(body);
    return this.http.post<Product>(this.baseURL + "/updateProduct/" +productId, body);
  }

  findProduct(productId:number):Observable<Product> {

    console.log("ProductId Find By FarmPartner Service"+productId)
    return this.http.get<Product>(this.baseURL +"/getProductById/"+ productId);  
  } 

  getAllProduct():Observable<Product[]> {

    return this.http.get<Product[]>(this.baseURL +"/getAllProducts");
  }

  deleteProduct(productId:number):Observable<string> {

    return  this.http.delete<string>(this.baseURL +`/deleteProduct/${productId}`);
  }

}
